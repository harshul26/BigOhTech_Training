
// ! validations with another approach
const typeValidator = ([...arg], type) => {
    return arg.every((it) => typeof it === type);
}

const argumentsValidator = ([...args], minimum, maximum) => {
    return (args.length >= minimum && args.length <= maximum);
}


const calculatorManager = ([...arg], op) => {
    return typeValidator(arg, 'number') ? ['+', '-', '*', '/', '%'].includes(op) ? arg.reduce((prev, curr) => eval(`${prev} ${op} ${curr}`)) : new Error('operator not valid') : new Error('Operands not valid');
}

//mapper 

const calculator = {
    addition: (...args) => {
        return argumentsValidator(args, 2) ? calculatorManager(args, "+") : new Error('number of arguments not valid');

    },
    subtraction: (...args) => {
        return argumentsValidator(args, 2) ? calculatorManager(args, "-") : new Error('number of arguments not valid');
    },

    multiplication: (...args) => {
        return argumentsValidator(args, 2) ? calculatorManager(args, "*") : new Error('number of arguments not valid');
    },

    division: (...args) => {
        try {
            if (argumentsValidator(args, 2)) {
                throw new Error('number of arguments not valid');
            }
            for (let i = 1; i < args.length; i++) {
                if (args[i] == 0) {
                    throw new Error("0 is not allowed in division");
                }
            }
            calculatorManager(args, "/");

        } catch (err) {
            //alert(err);
            console.log(err);
        }

    },

    modulus: (...args) => {
        try {
            if (argumentsValidator(args, 2)) {
                throw new Error('number of arguments not valid');
            }
            for (let i = 1; i < args.length; i++) {
                if (args[i] == 0) {
                    throw new Error("0 is not allowed in modulus");
                }

            }
            calculatorManager(args, '%');
        } catch (err) {
            //alert(err);
        }
    }



}

console.log(calculator.addition(2, 5));

console.log(calculator.multiplication(2, 5));
console.log(calculator.subtraction(2, 5));
console.log(calculator.division(2, 7, 5, 0));
console.log(calculator.modulus(70, 5));

// I am assuming maximum arguments should be 5
