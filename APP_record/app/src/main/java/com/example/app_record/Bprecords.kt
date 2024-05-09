package com.example.app_record;

data class Bprecords (
    val bprecords: List<Bprecord>
)

data class Bprecord(
    val datetime: String,
    val sys: Int,
    val dia: Int,
    val hr: Int
)


