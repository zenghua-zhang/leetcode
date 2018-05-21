package leetcode

class MostProfitAssigningWorkTest extends GroovyTestCase {

    MostProfitAssigningWork _test

    void setUp() {
        super.setUp()
        _test = new MostProfitAssigningWork()
    }

    void testMaxProfitAssignment() {
        int[] difficulty = [66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63]
        int[] profit = [66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77]
        int[] worker = [61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16]

        _test.maxProfitAssignment(difficulty, profit, worker)
        println result(difficulty, profit, worker)


    }

    private Integer result(int[] difficulty, int[] profit, int[] worker) {
        int ret = 0;
        for (int i : worker) {
            def v = findMax(difficulty, profit, i)
            println i + " : " + v
            ret += v
        }
        return ret

    }

    private Integer findMax(int[] difficulty, int[] profit, int max) {
        int ret = 0
        for (int i = 0; i < difficulty.length; i++) {
            int dif = difficulty[i]
            if (dif > max) {
                continue
            }

            ret = Math.max(profit[i], ret)


        }

        return ret
    }
}
