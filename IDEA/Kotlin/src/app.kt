import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.getStringLength
import java.lang.Integer.parseInt

/**
 * Created by gg on 7/4/2017.
 */
fun main(args: Array<String>) {
    println("Hello World!")
    println("sum(11,12)="+sum(11,12))
    println("sum(11,12,13)="+sum(11,12,13))
    println("sum(11,12,13,14)="+sum(11,12,13,14))
    printSum(21,22)
    printSum(21,22,23)
    vars(1,2,3,4,5)
    vars(1,2)
    var sumLambda : (Int,Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))
    var a:Int = 3
    println(a)
    val b:Int = 4
    println(b)
    var i:Int
    i = 2
    println(i)
    var c = 1
    println(c)
    var aa = 1
    val ss = "a is $aa"
    println(ss)
    a = 2
    val sss = "${ss.replace("is","was")},but now is $a"
    println(sss)

    println(getStringLength(1213))
    println(getStringLength("hello"))

    println("\n  for (i in 1..4)")
    for (i in 1..4) println(i)
    println("\n for (i in 4..1)")
    for (i in 4..1) println(i)
    println("\n  for(i in 1..10)")
    for(i in 1..10){
        println(i)
    }

    println("\n for (i in 1..4 step 2)")
    for (i in 1..4 step 2) print(i)
    println("\n for (i in 4 downTo  1 step 2)")
    for (i in 4 downTo  1 step 2) print(i)
    println("\n for (i in 1 until 10)")
    for (i in 1 until 10){
        println(i)
    }

    var age : String? = "23"
    val ages = age!!.toInt()
    val ages1 = age?.toInt()
    val ages2 = age?.toInt() ?: -1
    if(args.size<2){
        print("Two integers expected")
        return
    }
    val x = parseInt(args[0])
    val y = parseInt(args[1])
    if (x != null && y != null){
        print(x * y)
    }
}
fun sum(a:Int,b:Int):Int{
    return a+b
}
fun sum(a:Int,b:Int,c:Int) = a+b+c
public fun sum(a:Int,b:Int,c:Int,d:Int):Int = a+b+c+d
fun printSum(a:Int,b:Int):Unit{
    println(a+b)
}
public fun printSum(a:Int,b:Int,c:Int){
    println(a+b+c)
}
fun vars(vararg v:Int){
    for (vt in v){
        print(vt)
    }
    println()
}
fun getStringLength(obj:Any):Int?{
    if(obj is String) {
        return obj.length
    }
    return null
}