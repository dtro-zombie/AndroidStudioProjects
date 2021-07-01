package com.nahuelarias.agendalgti

var materiastxt = mutableListOf<Materias>()

var Codigo = ""

fun setcodigo(Cod:String)
{
    Codigo=Cod
}

fun getcodigo():String
{
    return Codigo
}


fun retornarmateria(Cod:String): Materias {

    var i=0



    var producto= materiastxt[i]

    materiastxt.forEach {

        val materiacomparar = materiastxt[i]

        if(materiacomparar.Codigo == Cod)
        {
            producto = materiastxt[i]
        }
            i++
    }



return producto
}

fun setMaterias(mater: MutableList<Materias>)
{

    materiastxt= mater

}

fun getMaterias():MutableList<Materias>
{
    return materiastxt
}


fun txtsplit(text:List<String>) : MutableList<Materias> {

    val textosplit = mutableListOf<Materias>()

    text.forEach {

        val miarraytexto: List<String> = it.split(";")

        val materias = Materias(miarraytexto[0], miarraytexto[1], miarraytexto[2], miarraytexto[3],miarraytexto[4], miarraytexto[5], miarraytexto[6], miarraytexto[7])

        textosplit.add(materias)

    }
    return textosplit




}
