package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ConsultoraTest : DescribeSpec({
  describe("Consultora") {
    val Juan = Empleado(200)
    val Manuel = Empleado(210)
    val Rosa = Empleado(220)
    val Alberto = Empleado(180)
    val Eva = Empleado(300)
    val Jose = Empleado(350)
    val Ignacio = Empleado(320)

    val tarea1 = TareaComun(Eva,20,3500, listOf(Juan,Manuel))
    val tarea2 = TareaComun(Jose,16,3000, listOf(Rosa,Alberto))
    val tareaInt = TareaIntegracion(listOf(tarea1,tarea2),Ignacio)

    it("Nomina de empleados de una tarea comun"){
      consultora.nominaEmpleados(tarea1).shouldBe(listOf(Juan,Manuel,Eva))
      consultora.nominaEmpleados(tarea2).shouldBe(listOf(Rosa,Alberto,Jose))
    }

    it("Horas necesarias para terminar tarea comun"){
      consultora.horasParaFinalizar(tarea1).shouldBe(10)
      consultora.horasParaFinalizar(tarea2).shouldBe(8)
    }

    it("Costo de una tarea comun"){
      consultora.costo(tarea1).shouldBe(13600)
      consultora.costo(tarea2).shouldBe(11800)
    }

    it("Nomina de empleados de una tarea integradora"){
      consultora.nominaEmpleados(tareaInt).shouldBe(listOf(Juan,Manuel,Eva,Rosa,Alberto,Jose,Ignacio))
    }

    it("Horas necesarias para terminar tarea integradora"){
      // 10 + 8 + 2(reunion)
      consultora.horasParaFinalizar(tareaInt).shouldBe(20)
    }

    it("Costo de una tarea integradora"){
      consultora.costo(tareaInt).shouldBe(26162)
    }
  }
})
