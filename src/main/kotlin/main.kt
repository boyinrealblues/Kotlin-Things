import kotlin.reflect.KFunction

class human(){
    var hands=2
    var eyes =2
    var mouth =1
}


fun human.mutate(){
    hands=3
    println(hands)
}

fun human.psychoMutate(human:human){
    human.hands =4
    println("i changed this person hands ${human.hands}")
    this.hands =3
    println("i changed my own hands ${this.hands}")
}

fun main(){

    val f = human()
    val f2=f::mutate //storing function as object into f2
    f2()  //executing f2

    val f3 = human::mutate
    f3(human()) //instance made

    val f4 = human::psychoMutate
    f4(human(),human())

    val f6 = human::hands
    println(f6(human()))

    val f5 =String::length
    f5("raghav").also {
        println(it)
    }

    val f7=human()::hands
    println(f7())

    val f8=A()::call
    f8()

}
class A(){
    fun function(factory:()->A){
        println("Came")
    }
    fun call(){
        function(::A)
    }
}
