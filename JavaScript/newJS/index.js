// const number =[1,2,3,4,5,6,7,8,9,10];
// console.log(number.map((elem)=>elem*2));

// const number = [10, 15, 20, 25, 30, 11, 24, 14, 15, 55, 45, 16];
// console.log(number.filter((num) => num >= 20, 0));
// console.log(number.reduce((num, sum) => num + sum, 0));

// const fruits = ["Apple", "Banana", "Papaya", "Orange", "Grapes"];
// fruits.forEach((elem) => {
// 	console.log("Fruits: " + elem);
// })

// const user = [
// 	{ name: "Araj", age: 23 },
// 	{ name: "Vinay", age: 20 },
// 	{ name: "Surya", age: 22 },
// 	{ name: "Mohan", age: 23 },
// 	{ name: "Bhagtu", age: 22 }
// ];

// console.log(user.map((elem) => elem.name));
// console.log(user.map((elem) => elem.age));


// let numbers = [12, 5, 8, 130, 44];
// console.log(numbers.filter((elem) => elem > 10));

// const number = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// let sqNumber = number.map((elem) => elem * elem).filter((elem) => elem % 2 == 0);
// console.log(sqNumber);

// console.log(number.reduce((acc, num) => {
// 	return num > acc ? num : acc;
// }, 0));
// const output = number.reduce((acc, elem) => {
// 	if (elem % 2 == 0) {
// 		acc.even.push(elem);
// 	} else {
// 		acc.odd.push(elem);
// 	}
// 	return acc;
// }, {
// 	even: [],
// 	odd: []
// }
// );

// console.log(output)

let employees = [
	{ name: "A", dept: "IT", salary: 50000 },
	{ name: "B", dept: "HR", salary: 30000 },
	{ name: "C", dept: "IT", salary: 70000 }
];

let emp = employees.map((val) => {
	let newSatary = 0;
	if (val.dept === "IT") {
		newSatary += val.salary;
	}
	return newSatary;
});
console.log(emp);