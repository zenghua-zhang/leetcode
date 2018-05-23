package leetcode

class ProductOfArrayExceptSelfTest extends GroovyTestCase {
    ProductOfArrayExceptSelf _test

    void setUp() {
        super.setUp()
        _test = new ProductOfArrayExceptSelf()
    }

    void testProductExceptSelf() {

        println _test.productExceptSelf([1, 2, 3, 4] as int[])
        println _test.productExceptSelf([1, 2] as int[])
        println _test.productExceptSelf([3, 3, 3] as int[])
    }
}
