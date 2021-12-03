package processing

import streams.*


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any {it.type == GradeType.A}
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { it.age }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { it.age >= minAge }
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.asSequence().filter { it.gender == Gender.MALE  }.count()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.asSequence().filter { it.gender == Gender.FEMALE }.map { it.age }.average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.asSequence().map { it.age }.reduce { acc, i -> acc*i }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.asSequence().filter { it.type.value != 0 }.map {it.type.value }.reduce {acc, i -> acc*i}
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    return student.grades.asSequence().filter { it.subject == Subject.MATH }.maxOrNull()
}

fun getSortedAges(students: List<Student>): List<Int> {
    return students.asSequence().map { it.age }.sorted().toList()
}

// endregion
