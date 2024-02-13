package edu.uw.ischool.harmaz.quizdroid

import java.io.Serializable

// DATA CLASSES
data class Topic(var name: String, var description: String, var questions: List<Question>) : Serializable

data class Question(var question: String, var options: List<String>, var correctAnswer: Int) : Serializable

// QUESTION LISTS
private val mathQuestions = listOf(
    Question(
        "What is the value of x in the equation 5x + 3 = 28?",
        listOf("x = 7", "x = 6", "x = 12", "x = 8"),
        0),
    Question(
        "If a circle has a radius of 10 centimeters, what is its circumference?",
        listOf("20 cm", "31.42 cm", "62.83 cm", "40 cm"),
        2),
    Question(
        "What is the value of 'a' in the equation 2a² - 5a + 3 = 0?",
        listOf("2", "1", "3", "4"),
        0)
)

private val physicsQuestions = listOf(
    Question(
        "What is the unit of measurement for electric charge?",
        listOf("Watts", "Volts", "Coulombs", "Joules"),
        2),
    Question(
        "When an object is in free fall, what is the acceleration due to gravity?",
        listOf("10 m/s²", "5.4 m/s²", "2 m/s²", "9.8 m/s²"),
        3),
    Question(
        "What is the force experienced by an object of mass 10 kg when it is subjected to an acceleration of 5 m/s²?",
        listOf(
            "10 N ",
            "50 N",
            "40 N",
            "80 N"),
        1)
)

private val marvelQuestions = listOf(
    Question(
        "How many Infinity stones are there?",
        listOf("2", "3", "8", "6"),
        3),
    Question(
        "What is the actor who plays Ironman?",
        listOf("Tom Holland", "Robert Downy Jr.", "Scarlett Johansson", "Gabriel Macht"),
        1),
    Question(
        "Which movie was the first movie of the MCU",
        listOf("Iron-man", "Shang-Chi", "Captain America: The First Avenger", "The Incredible Hulk"),
        0)
)

private val suitsQuestions = listOf(
    Question(
        "What is the name of the law firm where most of the action in 'Suits' takes place?",
        listOf("Pearson Hardman", "Specter Litt", "Zane Specter Litt Wheeler Williams", "Pearson Specter"),
        3),
    Question(
        "What is the name of the character played by Gabriel Macht, who is a top attorney and one of the main protagonists in 'Suits'?",
        listOf("Louis Litt", "Mike Ross", "Jessica Pearson", "Harvey Specter"),
        3),
    Question(
        "In which city is the law firm in 'Suits' located?",
        listOf("Chicago", "Los Angeles", "New York City", "Boston"),
        2)
)

// TOPICS
val mathTopic = Topic(
    MATH,
    "This quiz will test you on some basic math knowledge and test your problem-solving abilities. Good luck!\n\nTotal Questions: ${mathQuestions.size}",
    mathQuestions)

val physicsTopic = Topic(
    PHYSICS,
    "This quiz will test you on some physics fundamentals and test your problem-solving abilities. Good luck!\n\nTotal Questions: ${physicsQuestions.size}",
    physicsQuestions)

val marvelTopic = Topic(
    MARVEL,
    "This quiz will test your knowledge of the Marvel Universe and the super heroes that work to protect it. Good luck!\n\nTotal Questions: ${marvelQuestions.size}",
    marvelQuestions)

val suitsTopic = Topic(
    SUITS,
    "This quiz will test your knowledge of the legal drama series 'Suits' and its characters. Good luck!\n\nTotal Questions: ${suitsQuestions.size}",
    suitsQuestions)