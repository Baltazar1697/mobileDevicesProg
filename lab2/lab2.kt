abstract class Employee(
    var name: String,
    var surname: String,
    var baseSalary: Int,
    var experience: Int
) {
    open val countedSalary: Double
    get() {
        return when {
            experience > 2 && experience < 5 -> (baseSalary + 200).toDouble()
            experience >= 5 -> (baseSalary * 1.2 + 500).toDouble()
            else -> baseSalary.toDouble() // Provide a default value here
        }
    }
}

class Developer(
    name: String,
    surname: String,
    baseSalary: Int,
    experience: Int
) : Employee(name, surname, baseSalary, experience) {
}

class Designer(
    name: String,
    surname: String,
    baseSalary: Int,
    experience: Int,
    effCoef: Double
) : Employee(name, surname, baseSalary, experience) {
    var effCoef = checkCoef(effCoef)
        set(value) {
            field = checkCoef(value)
        }
    
    private fun checkCoef(coef: Double): Double {
        if (coef > 1) {
            return 1.0
        } else if ( coef < 0) {
            return 0.0
        } else {
            return coef
        }
    }

    override val countedSalary: Double
        get() {
            val baseSalaryExperienced = super.countedSalary
            val efficiencyCoef = effCoef
            return baseSalaryExperienced * effCoef
        }
}

class Manager(
    name: String,
    surname: String,
    baseSalary: Int,
    experience: Int,
    val team: MutableList<Employee> = mutableListOf()
) : Employee(name, surname, baseSalary, experience) {
    override val countedSalary: Double
        get() {
            val baseSalaryExperienced = super.countedSalary
            val developersCount = team.count { it is Developer }
            val effCoef = if (developersCount > team.size / 2){
                1.1
            } else {
                1.0
            } // Can cause floating point calculations
            return when {
                team.size > 5 && team.size <= 10 -> ((baseSalaryExperienced + 200) * effCoef).toDouble()
                team.size > 10 -> ((baseSalaryExperienced + 300)* effCoef).toDouble()
                else -> (baseSalaryExperienced * effCoef).toDouble() 
            } 
        }
    
}

class Department(
    val managers: MutableList<Manager> = mutableListOf()
) {
    fun giveSalary() {
        managers.forEach {
            it.team.forEach {
                println(it.name + " " + it.surname + " отримав " + it.countedSalary + " шекєлей")
            }
            println(it.name + " " + it.surname + " отримав " + it.countedSalary + " шекєлей")
        }
    }
}

fun main() {
    val Dima = Developer("Dima", "Romanchenko", 2000,3)
    val Nikita = Developer("Nikita", "Romanchenko", 1000,1)
    val Alex = Developer("Alex", "Romanchenko", 5000,10)
    val Ira = Developer("Ira", "Merzla", 1600,1)
    val IvanZ = Designer("Ivan", "Zhytkevich", 3000,6,1.7)
    val IvanM = Designer("Ivan", "Merzliy", 1200,1,0.6)
    val Till = Manager("Till", "Lindemann", 2500,10)
    val IT = Department()
    IT.managers.add(Till)
    Till.team.add(Dima)
    Till.team.add(Nikita)
    Till.team.add(Alex)
    Till.team.add(Ira)
    Till.team.add(IvanZ)
    Till.team.add(IvanM)
    IT.giveSalary()
}
