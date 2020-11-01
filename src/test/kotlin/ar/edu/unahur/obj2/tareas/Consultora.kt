package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec

class Consultora : DescribeSpec({
  describe("Consultora") {
    val Juan = Empleado(200)
    val Manuel = Empleado(210)
    val Rosa = Empleado(220)
    val Alberto = Empleado(180)
    val Eva = Empleado(500)
    val Jose = Empleado(450)
    val Ignacio = Empleado(480)

    val tarea1 = TareaComun(Eva,20,100, listOf(Juan,Manuel))
    val tarea2 = TareaComun(Jose,20,100, listOf(Rosa,Alberto))
    val tareaInt = TareaIntegracion(listOf(tarea1,tarea2),Ignacio)

    it("Nomina de empleados de una tarea comun"){

    }
  }
})
