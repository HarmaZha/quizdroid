package edu.uw.ischool.harmaz.quizdroid

interface TopicRepository {
    fun getTopics(): List<Topic>
    fun getTopic(topicIndex: Int): Topic
    fun getQuiz(topicIndex: Int, quizIndex: Int): Quiz

}

data class Topic(var title: String, var shortDescription: String, var longDescription: String, var questions: MutableList<Quiz>, var iconId: Int)

data class Quiz(var question: String, var options: List<String>, var correctAnswer: Int)

class TopicRepositoryImpl : TopicRepository {
    private var topics: MutableList<Topic>

    init {
        val mathQuestions = mutableListOf(
            Quiz(
                "What is the value of x in the equation 5x + 3 = 28?",
                listOf("x = 5", "x = 6", "x = 12", "x = 8"),
                0
            ),
            Quiz(
                "If a circle has a radius of 10 centimeters, what is its circumference?",
                listOf("20 cm", "31.42 cm", "62.83 cm", "40 cm"),
                2
            ),
            Quiz(
                "What is the value of 'a' in the equation 2a² - 5a + 3 = 0?",
                listOf("2", "1", "3", "4"),
                1
            )
        )

        val physicsQuestions = mutableListOf(
            Quiz(
                "What is the unit of measurement for electric charge?",
                listOf("Watts", "Volts", "Coulombs", "Joules"),
                2
            ),
            Quiz(
                "When an object is in free fall, what is the acceleration due to gravity?",
                listOf("10 m/s²", "5.4 m/s²", "2 m/s²", "9.8 m/s²"),
                3
            ),
            Quiz(
                "What is the force experienced by an object of mass 10 kg when it is subjected to an acceleration of 5 m/s²?",
                listOf(
                    "10 N ",
                    "50 N",
                    "40 N",
                    "80 N"),
                1
            )
        )

        val marvelQuestions = mutableListOf(
            Quiz(
                "How many Infinity stones are there?",
                listOf("2", "3", "8", "6"),
                3
            ),
            Quiz(
                "What is the actor who plays Ironman?",
                listOf("Tom Holland", "Robert Downy Jr.", "Scarlett Johansson", "Gabriel Macht"),
                1
            ),
            Quiz(
                "Which movie was the first movie of the MCU came out first",
                listOf("Iron-man", "Shang-Chi", "Captain America: The First Avenger", "The Incredible Hulk"),
                0
            )
        )

        val suitsQuestions = mutableListOf(
            Quiz(
                "What is the name of the law firm where most of the action in 'Suits' takes place?",
                listOf("Pearson Hardman", "Specter Litt", "Zane Specter Litt Wheeler Williams", "Pearson Specter"),
                3
            ),
            Quiz(
                "What is the name of the character played by Gabriel Macht, who is a top attorney and one of the main protagonists in 'Suits'?",
                listOf("Louis Litt", "Mike Ross", "Jessica Pearson", "Harvey Specter"),
                3
            ),
            Quiz(
                "In which city is the law firm in 'Suits' located?",
                listOf("Chicago", "Los Angeles", "New York City", "Boston"),
                2
            )
        )

        topics = mutableListOf(
            Topic(
                MATH,
                "Test your math skills with these challenges.",
                "This quiz will test you on your math knowledge as well as your problem-solving abilities.",
                mathQuestions,
                R.drawable.math_icon
            ),
            Topic(
                PHYSICS,
                "Test your knowledge of physics fundamentals.",
                "This quiz will test you on your physics knowledge as well as your problem-solving abilities.",
                physicsQuestions,
                R.drawable.physics_icon
            ),
            Topic(
                MARVEL,
                "Dive into the Marvel Universe with your favorite heroes.",
                "This quiz will test your knowledge of the Marvel Universe and the super heroes that work to protect it",
                marvelQuestions,
                R.drawable.marvel_icon
            ),
            Topic(
                SUITS,
                "Suits is the best show out there.",
                "This quiz will test your knowledge of the legal drama series 'Suits' and its characters.",
                suitsQuestions,
                R.drawable.suits_icon
            )
        )
    }

    override fun getTopics(): List<Topic> {
        return topics
    }

    override fun getTopic(topicIndex: Int): Topic {
        return topics[topicIndex]
    }

    override fun getQuiz(topicIndex: Int, quizIndex: Int): Quiz {
        return topics[topicIndex].questions[quizIndex]
    }

}