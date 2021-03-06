<h2 class="github">Changelog</h2>

This list is not currently intended to be all-encompassing - it will document major and breaking API changes with their
rationale when appropriate:

### v1.4 - 5 Feb 2021

- switched to Kotlin 1.4

### v1.3.1

- fixing bug in WIP tests with exceptions

### v1.3

- showing passing steps in WIP tests
- making WIP tests failing if all steps succeeded (so you remember removing the marker)
- better error message for startup failures

### v1.2
- passing protocol to inside the ddtScenario
- allowing actors to exchange context

### v1.1
- fixed a bug when failing on the first protocol of the scenario (for real)
- added more JavaDoc
- tidy up internal code

### v1.0
- fixed a bug when failing on the first protocol of the scenario
- started JavaDoc documentation
- cleaning up internal code
- moved core classes to com.ubertob.pesticide.core package
- better method names for StepContext

### v0.9.12
- going back in using api for JUnit dependency because of IntelliJ resolution
- settings block doesn't require a result
- if no protocols is selected, the test will fail
- changed protocol InMemoryHubs to DomainOnly and PureHttp to Http

### v0.9.11
- using implementation instead of api for JUnit dependency because of IntelliJ resolution

### v0.9.10
- changed name of class BoundedContextInterpreter to DomainInterpreter
- added ActorWithContext class for Actors that must store and retrive info during the test

### v0.9.9
- changed name of class DomainUnderTest to BoundedContextInterpreter

### v0.9.8
- changed DomainUnderTest.isReady() to prepare()

### v0.9.7
- added actor name to the step auto naming

### v0.9.6
- pass the domain from one step to the next
- improved the step auto naming

### v0.9.5
- added junit5 as api dependency

### v0.9.4
- made DdtActor abstract class instead of Interface, to avoid using JvmDefault

### v0.9.3
- others small changes to make Java tests easier

### v0.9.2
- added Java examples and made api more friendly to Java

### v0.9.1
- initial version

