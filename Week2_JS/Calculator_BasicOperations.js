


const validator = ([...arg], type) => {
    return arg.every((it) => typeof it === type);
}


const calculatorManager = ([...arg], op) => {
    return validator(arg, 'number') ? ['+', '-', '*', '/'].includes(op) ? arg.reduce((prev, curr) => eval(`${prev} ${op} ${curr}`)) : new Error('operator not valid') : new Error('Operands not valid');
}

//mapper 

const calculator = {
    addition: (a, b) => calculatorManager([a, b], "+"), // execute // validator
    subtraction: (a, b) => calculatorManager([a, b], "-"),
    multiplication: (a, b) => calculatorManager([a, b], "*"),
    division: (a, b) => calculatorManager([a, b], "/")
}

console.log(calculator.addition(2, 5, 7));
console.log(calculator.multiplication(2, 5));
console.log(calculator.subtraction(2, 5));
console.log(calculator.division(2, 5));
