package leetcode

class SumOfDistancesInTreeTest extends GroovyTestCase {
    private SumOfDistancesInTree _test

    void setUp() {
        super.setUp()
        _test = new SumOfDistancesInTree()
    }

    void testSumOfDistancesInTree() {
        int[][] edges = [[0, 1], [0, 2], [2, 3], [2, 4], [2, 5]]

        assert _test.sumOfDistancesInTree(6, edges) ==  _test.sumOfDistancesInTreeWithClass(6, edges)
    }

    void testAnother() {
        int[][] edges = [[175,146],[22,11],[59,147],[198,102],[189,166],[150,108],[118,39],[59,93],[23,129],[72,94],[8,37],[110,74],[44,128],[196,169],[125,78],[100,172],[113,97],[28,97],[94,33],[54,72],[195,146],[1,20],[192,154],[118,65],[44,116],[42,47],[150,178],[134,24],[66,3],[154,70],[63,26],[147,137],[148,152],[142,163],[119,46],[123,178],[182,69],[0,13],[106,7],[65,90],[194,111],[2,13],[45,104],[154,11],[154,10],[23,40],[13,130],[160,61],[11,87],[5,13],[105,138],[8,47],[99,37],[169,65],[162,58],[74,6],[57,83],[65,63],[96,35],[175,29],[21,161],[63,82],[60,187],[107,62],[0,38],[116,145],[157,59],[90,197],[155,73],[90,178],[137,140],[139,93],[115,93],[156,39],[6,144],[96,48],[120,17],[57,23],[125,168],[3,50],[191,90],[79,179],[104,168],[39,79],[13,90],[180,158],[111,28],[103,60],[180,14],[34,166],[164,193],[164,133],[19,96],[132,81],[48,34],[65,101],[161,8],[11,128],[62,180],[166,43],[53,91],[59,165],[186,167],[3,88],[71,170],[147,148],[146,78],[24,69],[68,149],[65,31],[72,30],[170,184],[36,49],[111,60],[64,122],[105,17],[86,78],[25,163],[11,17],[28,149],[142,50],[73,67],[124,131],[128,4],[142,116],[14,56],[44,8],[177,31],[112,70],[194,126],[116,83],[98,41],[60,116],[109,172],[7,128],[31,32],[193,163],[80,71],[59,73],[8,55],[171,32],[128,9],[16,22],[1,122],[180,127],[47,181],[120,188],[186,84],[100,15],[48,131],[49,141],[64,134],[52,64],[174,3],[185,123],[194,117],[160,57],[85,33],[90,44],[71,31],[8,49],[104,11],[122,186],[47,77],[158,143],[76,94],[27,142],[73,158],[71,58],[176,42],[111,89],[135,102],[136,35],[134,6],[23,151],[48,44],[95,83],[64,166],[94,48],[159,94],[173,171],[104,183],[142,132],[52,114],[8,147],[196,199],[147,98],[102,6],[12,70],[128,53],[160,18],[124,153],[51,107],[183,46],[70,92],[121,112],[31,100],[190,62],[75,61]]

        assert _test.sumOfDistancesInTree(200, edges) ==  _test.sumOfDistancesInTreeWithClass(200, edges)
    }
}
