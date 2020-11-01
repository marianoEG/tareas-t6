package ar.edu.unahur.obj2.tareas

abstract class Tarea(val responsable: Empleado){
    abstract fun horasNecesarias() : Int
    abstract fun costo() : Int
    abstract fun nominaEmpleados() : List<Empleado>
}

class TareaComun(responsable : Empleado, val horasEstimadas : Int, val costoInfraestructura : Int, val empleadosAsignados : List<Empleado>) : Tarea(responsable){

    override fun horasNecesarias() = horasEstimadas / empleadosAsignados.size

    override fun costo() =
        empleadosAsignados.sumBy { it.cobroPorHora * this.horasNecesarias() } + horasEstimadas * responsable.cobroPorHora + costoInfraestructura

    override fun nominaEmpleados() = empleadosAsignados + responsable
}

class TareaIntegracion(val tareas : List<Tarea>, responsable: Empleado) : Tarea(responsable){

    override fun horasNecesarias() = tareas.sumBy { it.horasNecesarias() } + this.horasReunion()

    fun horasReunion() = tareas.sumBy { it.horasNecesarias() } / 8

    override fun costo() = (tareas.sumBy { it.costo() } + this.bonusResponsable()).toInt()

    fun bonusResponsable() = tareas.sumBy { it.costo() } * 0.03f

    override fun nominaEmpleados() = tareas.flatMap { it.nominaEmpleados() } + responsable
}

class Empleado(val cobroPorHora : Int)