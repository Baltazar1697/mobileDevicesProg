import kotlin.math.sqrt

fun isEven(arg: Int?): String {
        if (arg != null && arg % 2 == 0) {
            return "even"
        } else {
            return "odd"
    }

}

fun sumSimple(): Int {
    val numbers = mutableListOf<Int>()
    var counter = 0
    var number = 1
    while (counter < 5){
    Label@   for (i in 2..(sqrt(number.toDouble()).toInt())){

                if (number%i == 0){
                    number++
                    break@Label
                }
        }

        numbers.add(number)
        number++
        counter++
    }
    return numbers.sum()

}

fun sumOnes(n:Int): Int {
    var number:Int = 1
    for (i in 2..n){
        var temp = "1".repeat(i).toInt()
        number+=temp
    }
    return number
    
}
fun main() {
    var arg:Int? = 10
    var result = isEven(arg)
    println("$arg is $result")
    
    arg = 11
    result = isEven(arg)
    println("$arg is $result")
    val result2 = sumSimple()
    println("Sum of first 5 prime numbers is $result2")
    var test:Int = 6
    var result3 = sumOnes(test)
    println("The result of summing 1 $test times will be $result3") 
}