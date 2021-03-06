package com.ubertob.pesticide.examples.googlepage

import com.ubertob.pesticide.core.DDT
import com.ubertob.pesticide.core.DomainDrivenTest
import java.time.LocalDate

class GooglePageDDT : DomainDrivenTest<GooglePageInterpreter>(
    setOf(
        GooglePageInterpreter()
    )
) {

    val googleUser by NamedActor(::GoogleUser)

    @DDT
    fun `user can search for a word`() = ddtScenario {

        withoutSetting atRise play(

            googleUser.`search for`("pesticide github kotlin"),

            googleUser.`can see among results`("uberto")

        ).wip(LocalDate.of(2021, 12, 31), "Google Cookies popup")
    }
}