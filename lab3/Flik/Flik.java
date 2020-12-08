/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {

        return a.equals(b);
    }
}

/**这是因为int基础类最大只能为127，在它的对象类中-128到127的数保存在静态区，而大于127的数保存在对象区，
        所以直接比较，相当于比较他们的地址，所以就是不相等的，但是比较他们的内容确实一样的**/
