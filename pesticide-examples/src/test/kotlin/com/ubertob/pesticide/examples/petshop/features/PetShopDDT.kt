package com.ubertob.pesticide.examples.petshop.features

import com.ubertob.pesticide.core.DDT
import com.ubertob.pesticide.core.DomainDrivenTest
import com.ubertob.pesticide.examples.petshop.model.Pet
import com.ubertob.pesticide.examples.petshop.testing.PetBuyer
import com.ubertob.pesticide.examples.petshop.testing.PetShopInterpreter
import com.ubertob.pesticide.examples.petshop.testing.ShopAssistant
import com.ubertob.pesticide.examples.petshop.testing.allPetShopInterpreters


class PetShopDDT : DomainDrivenTest<PetShopInterpreter>(allPetShopInterpreters) {

    val mary by NamedActor(::PetBuyer)
    val bert by NamedActor(::PetBuyer)

    val adam by NamedActor(::ShopAssistant)

    @DDT
    fun `mary buys a lamb`() = ddtScenario {
        val lamb = Pet("lamb", 64)
        val hamster = Pet("hamster", 12)
        setting {
            populateShop(lamb, hamster)
        } atRise play(
            mary.`check that the price of $ is $`("lamb", 64),
            mary.`check that the price of $ is $`("hamster", 12),
            mary.`put $ into the cart`("lamb"),
            mary.`check that there are no more $ for sale`("lamb"),
            mary.`checkout with pets $`("lamb")
        )
    }

    @DDT
    fun `mary buys a lamb and bert buys a hamster`() = ddtScenario {
        val lamb = Pet("lamb", 64)
        val hamster = Pet("hamster", 12)
        setting {
            populateShop(lamb, hamster)
        } atRise play(
            mary.`put $ into the cart`("lamb"),
            bert.`check that there are no more $ for sale`("lamb"),
            bert.`put $ into the cart`("hamster"),
            mary.`checkout with pets $`("lamb"),
            bert.`checkout with pets $`("hamster")
        )
    }

    @DDT
    fun `shop assistance check the pets`() = ddtScenario {
        val parrot = Pet("parrot", 100)
        val bunny = Pet("bunny", 70)
        setting {
            populateShop(parrot, bunny)
        } atRise play(
            adam.`check that $ is in the shop`(parrot),
            adam.`check that $ is in the shop`(bunny)
        )
    }

    //check that cannot add to cart after checkout
    @DDT
    fun `mary cannot put another pet in the cart after checkou`() = ddtScenario {
        val lamb = Pet("lamb", 64)
        val hamster = Pet("hamster", 12)
        setting {
            populateShop(lamb, hamster)
        } atRise play(
            mary.`put $ into the cart`("lamb"),
            mary.`checkout with pets $`("lamb"),
            mary.`cannot put $ into the cart`("hamster")
        )
    }


}


