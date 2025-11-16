// ================================================================
// ASSIGNMENT 2  —  ALL QUESTIONS IN ONE FILE
// ================================================================

// ========================= Q1. Scope Conflict Resolver =========================

console.log("---- Q1: Scope Conflict Resolver ----");

let bonus = 5000; // Global variable

function calculateSalary(isPermanent) {
    let salary = 40000; // Local variable

    if (isPermanent) {
        salary += bonus;
    }

    console.log(`Is Permanent: ${isPermanent}, Total Salary: ${salary}`);
}

// Test with different values
calculateSalary(true);
calculateSalary(false);

console.log("Global bonus remains unchanged:", bonus);


// ========================= Q2. String Manipulation Report =========================

console.log("\n---- Q2: String Manipulation Report ----");

let product = " wireless headphones PRO ";

let cleanedTitle = product
    .trim()
    .toLowerCase()
    .split(" ")
    .filter(w => w.length > 0)
    .map(w => w[0].toUpperCase() + w.slice(1))
    .join(" ")
    .replace("Pro", "Pro Edition");

console.log("Cleaned Title:", cleanedTitle);
console.log("Length:", cleanedTitle.length);


// ========================= Q3. Math Utility Dashboard =========================

console.log("\n---- Q3: Math Utility Dashboard ----");

let x = 16.75;

let mathSummary = `
Rounded Value: ${Math.round(x)}
Square Root: ${Math.sqrt(x)}
Power (x^3): ${Math.pow(x, 3)}
Random (10-50): ${Math.floor(Math.random() * 41) + 10}
`;

console.log(mathSummary);


// ========================= Q4. Array Performance Analyzer =========================

console.log("---- Q4: Array Performance Analyzer ----");

let scores = Array.from({ length: 8 }, () => Math.floor(Math.random() * 71) + 30);

let highest = Math.max(...scores);
let lowest = Math.min(...scores);
let average = scores.reduce((sum, s) => sum + s, 0) / scores.length;
let passed = scores.filter(s => s >= 50).length;

console.log("Scores:", scores);
console.log("Highest:", highest);
console.log("Lowest:", lowest);
console.log("Average:", average.toFixed(2));
console.log("Passed Students:", passed);


// ========================= Q5. Boolean Logic Access System =========================

console.log("\n---- Q5: Boolean Logic Access System ----");

let isDoorLocked = true;
let isWindowClosed = true;
let isAlarmOn = true;
let isOwnerInside = false;

if (isAlarmOn && isDoorLocked && isWindowClosed && isOwnerInside) {
    console.log("Secure");
} else {
    console.log("Unsafe");
}


// ========================= Q6. Event-Based Counter Simulation =========================

console.log("\n---- Q6: Event-Based Counter Simulation ----");

let count = 0;

function increment() {
    count++;
    console.log("Count:", count);
}

function decrement() {
    count--;
    console.log("Count:", count);
}

function simulateClicks() {
    function nestedUpdate() {
        console.log("Nested Function Count View:", count);
    }

    increment();
    increment();
    decrement();
    nestedUpdate();
}

simulateClicks();


// ========================= Q7. Customer Feedback Processor =========================

console.log("\n---- Q7: Customer Feedback Processor ----");

let feedback = "Great product! Fast delivery and amazing sound quality!";

let wordCount = feedback.split(" ").length;

let containsNegative =
    feedback.toLowerCase().includes("bad") ||
    feedback.toLowerCase().includes("poor");

console.log("Word Count:", wordCount);

if (!containsNegative) {
    console.log("Positive Feedback");
} else {
    console.log("Needs Improvement");
}


// ========================= Q8. Dynamic Discount Evaluator =========================

console.log("\n---- Q8: Dynamic Discount Evaluator ----");

const cart = [
    { item: "Laptop", category: "electronics", price: 45000 },
    { item: "Shoes", category: "fashion", price: 2500 },
    { item: "Book", category: "education", price: 600 }
];

let totalPrice = 0;

cart.forEach(product => {
    let discount = 0;

    if (product.category === "electronics") discount = 0.10;
    else if (product.category === "fashion") discount = 0.05;

    let finalPrice = product.price - (product.price * discount);
    totalPrice += finalPrice;
});

if (totalPrice > 50000) {
    totalPrice -= totalPrice * 0.05;
}

console.log("Final Cart Total:", totalPrice);


// ========================= Q9. Odd–Even Number Analyzer =========================

console.log("\n---- Q9: Odd–Even Number Analyzer ----");

let rangeArray = [];
let analysisResult = [];

for (let i = 1; i <= 30; i++) {
    rangeArray.push(i);
}

rangeArray.forEach(num => {
    if (num % 3 === 0 && num % 5 === 0) {
        analysisResult.push("FizzBuzz");
    } else if (num % 2 === 0) {
        analysisResult.push("Even");
    } else {
        analysisResult.push("Odd");
    }
});

console.log(analysisResult);


// ========================= Q10. Departmental Employee Evaluator =========================

console.log("\n---- Q10: Departmental Employee Evaluator ----");

const departments = [
    ["HR", 72],
    ["Finance", 88],
    ["Tech", 95],
    ["Support", 63]
];

departments.forEach(([dept, score]) => {
    let status = "";

    if (score >= 90) status = "Excellent";
    else if (score >= 75) status = "Good";
    else if (score >= 60) status = "Average";
    else status = "Needs Improvement";

    console.log(`${dept}: ${status}`);
});
