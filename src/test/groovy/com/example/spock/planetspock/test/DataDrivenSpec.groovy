package com.example.spock.planetspock.test

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DataDrivenSpec extends Specification {
    @Shared
    String elem = " push on stack"
    void setupSpec() {
        println "Run before the first testing function"
    }

    void cleanupSpec() {
        println "Run after the last testing function"
    }

    void setup() {
        println "Run before every testing function"
    }

    void cleanup() {
        println "Run after every testing function"
    }

    def "max of two values" () {
        expect :
        Math.max(a,b) == c

        where :
        a << [3, 6, 8, 9]
        b << [3, 5, 1, 10]
        c << [3, 6, 8, 1]
    }
    def "minimum of #a and #b is #c"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 4
        9 | 9 || 9
    }
    def "test stack"() {
        setup: // cai dat dac ta cho feature
        Stack stack = new Stack()

        when: // xu ly
        stack.push(elem)

        then: // ky vong ket qua
        stack.isEmpty()
        stack.size()==1

         }
}
