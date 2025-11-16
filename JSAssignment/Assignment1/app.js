// Utility function to print on webpage
function print(title, content) {
    const output = document.getElementById("output");
    output.innerHTML += `
        <div class="section">
            <h2>${title}</h2>
            <p>${content}</p>
        </div>
    `;
}

// -------------------------------------------
// Q1. Personalized Login Greeting
let userName = "Faishal";
let currentHour = new Date().getHours();

let greeting = currentHour < 12
    ? `Good Morning ${userName}!`
    : currentHour < 17
        ? `Good Afternoon ${userName}!`
        : `Good Evening ${userName}!`;

print("Q1: Personalized Login Greeting", greeting);


// -------------------------------------------
// Q2. Multi-Type Data Summary
let str = "Hello";
let num = 25;
let bool = true;
let arr = [1, 2, 3];
let obj = { name: "Faishal", age: 20 };
let empty = null;
let notDefined;

let dataSummary = `
String: ${str} (${typeof str})<br>
Number: ${num} (${typeof num})<br>
Boolean: ${bool} (${typeof bool})<br>
Array: ${arr} (array)<br>
Object: ${JSON.stringify(obj)} (${typeof obj})<br>
Null: null (null)<br>
Undefined: undefined (undefined)
`;

print("Q2: Multi-Type Data Summary", dataSummary);


// -------------------------------------------
// Q3. Monthly Expense Tracker
let expenses = [3000, 800, 12000, 2500, 1500];

let total = expenses.reduce((sum, x) => sum + x, 0);
let average = total / expenses.length;
let finalAmount = total + total * 0.10;

let expenseOutput = `
Total: ₹${total.toFixed(2)}<br>
Average: ₹${average.toFixed(2)}<br>
Final After 10% Tax: ₹${finalAmount.toFixed(2)}
`;

print("Q3: Monthly Expense Tracker", expenseOutput);


// -------------------------------------------
// Q4. Academic Performance Evaluator
let marks = [85, 72, 90, 65, 80];
let anyFail = marks.some(m => m < 35);
let percentage = marks.reduce((a, b) => a + b, 0) / 5;

let result;

if (anyFail) result = "Detained (Failed in a subject)";
else if (percentage >= 85) result = "Promoted with Distinction";
else if (percentage >= 50) result = "Promoted";
else result = "Detained";

print("Q4: Academic Performance Evaluator", result);


// -------------------------------------------
// Q5. Weather Activity Planner
let temperature = 28;
let isRaining = false;
let windSpeed = 10;

let weatherMsg;

if (isRaining) weatherMsg = "Stay indoors with hot coffee.";
else if (temperature > 35) weatherMsg = "Go swimming.";
else if (temperature < 15 && windSpeed > 20) weatherMsg = "Too cold and windy — stay home.";
else weatherMsg = "Perfect day for a walk.";

print("Q5: Weather Activity Planner", weatherMsg);


// -------------------------------------------
// Q6. Discount System
let totalPurchase = 7500;
let discount = totalPurchase >= 10000 ? 25 :
               totalPurchase >= 5000 ? 15 :
               totalPurchase >= 2000 ? 5 : 0;

let finalPrice = totalPurchase - (totalPurchase * discount / 100);

let discountOutput = `
Original: ₹${totalPurchase}<br>
Discount: ${discount}%<br>
Final Price: ₹${Math.round(finalPrice)}
`;

print("Q6: Progressive Discount System", discountOutput);


// -------------------------------------------
// Q7. Guessing Game
let secret = Math.floor(Math.random() * 50) + 1;
let userGuess = 23;

let guessResult;

if (userGuess === secret) guessResult = "Correct guess!";
else if (Math.abs(secret - userGuess) <= 3) guessResult = "Very close!";
else if (userGuess > secret) guessResult = "Too high!";
else guessResult = "Too low!";

print("Q7: Smart Guessing Game", `Secret: ${secret}, Guess: ${userGuess}<br>${guessResult}`);


// -------------------------------------------
// Q8. Salary Projection
let currentSalary = 30000;
let incrementRate = 10;
let output = "";

for (let year = 1; year <= 5; year++) {
    currentSalary += currentSalary * (incrementRate / 100);
    output += `Year ${year}: ₹${Math.round(currentSalary)}<br>`;
}

print("Q8: Salary Projection (5 Years)", output);


// -------------------------------------------
// Q9. Random Math Quiz
let num1 = Math.floor(Math.random() * 20) + 1;
let num2 = Math.floor(Math.random() * 20) + 1;
let ops = ['+', '-', '*', '/'];
let op = ops[Math.floor(Math.random() * ops.length)];

let correct;

switch (op) {
    case '+': correct = num1 + num2; break;
    case '-': correct = num1 - num2; break;
    case '*': correct = num1 * num2; break;
    case '/': correct = (num1 / num2).toFixed(2); break;
}

print("Q9: Math Quiz Generator", `${num1} ${op} ${num2} = ${correct}`);


// -------------------------------------------
// Q10. Citizen Eligibility Validator
let age = 19;
let isCitizen = true;

let eligibility;

if (isCitizen && age >= 18) eligibility = "Eligible for all services.";
else if (isCitizen && age >= 18 && age <= 20) eligibility = "Eligible to vote only.";
else if (!isCitizen && age >= 18) eligibility = "Only age criteria met.";
else eligibility = "Not eligible yet.";

print("Q10: Eligibility Validator", eligibility);
