package com.dmartinc.ports.output

interface HitsRepository {
    fun insertHit()
    fun countHits(): Long
}