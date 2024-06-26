
const typeValidator = ([...arg], type) => {
    return arg.every((it) => typeof it === type);
}

const argumentsValidator = ([...args], minimum, maximum) => {
    return (args.length >= minimum && args.length <= maximum);
}

const basicCalculatorManager = ([...arg], op, minimum, maximum) => {
    return typeValidator(arg, 'number') ? argumentsValidator(args, minimum, maximum) ? ['+', '-', '*', '/', '%'].includes(op) ? arg.reduce((prev, curr) => eval(`${prev} ${op} ${curr}`)) : new Error('no of arguments not valid') : new Error('operator not valid') : new Error('Operands not valid');
}
const squareRootManager = (numbers) => {
    if (typeValidator(numbers, 'number') && argumentsValidator(numbers, 1, 1)) {
        numbers.map((number, index) => {
            let start = 0,
                end = number,
                mid, ans;

            while (start <= end) {
                mid = Math.floor((start + end) / 2);

                if (mid * mid == number) {
                    ans = mid;
                    break;
                } else if (mid * mid < number) {
                    ans = mid;
                    start = mid + 1;
                } else if (mid * mid > number) {
                    end = mid - 1;
                }
            }

            let increment = 0.1;

            for (let i = 0; i < 2; i++) {
                while (ans * ans <= number) {

                    ans += increment;
                }

                ans -= increment;
                increment /= 10;
            }

            return ans;
        });
    } else {
        new Error('invalid arguments');
    }
}

//mapper 

const calculator = {
    addition: (...args) => {
        return basicCalculatorManager(args, "+", 2, 5);

    },
    subtraction: (...args) => {
        return basicCalculatorManager(args, "-", 2, 5);
    },

    multiplication: (...args) => {
        return basicCalculatorManager(args, "*", 2, 5);
    },

    division: (...args) => {
        try {
            for (let i = 1; i < args.length; i++) {
                if (args[i] == 0) {
                    throw new Error("0 is not allowed in division");
                }
            }
            basicCalculatorManager(args, "/", 2, 5);

        } catch (err) {
            //alert(err);
            console.log(err);
        }

    },

    modulus: (...args) => {
        try {
            for (let i = 1; i < args.length; i++) {
                if (args[i] == 0) {
                    throw new Error("0 is not allowed in modulus");
                }

            }
            basicCalculatorManager(args, '%', 2, 5);
        } catch (err) {
            //alert(err);
        }
    },

    square: (...args) => {
        try {
            return basicCalculatorManager([...args, ...args], '*', 1, 1);
        } catch (err) {
            //alert(err);
        }
    },

    squareRoot: (...args) => {
        squareRootManager(args);
    },

    log: (...args) => {
        try {
            return argumentsValidator(args, 1, 1) ? typeValidator(args, 'number') ? Math.log10(args) : new Error('no of arguments not valid') : new Error('arguments not valid');
        } catch (err) {
            //alert(err);
        }
    },

    ln: (...args) => {
        try {
            return argumentsValidator(args, 1, 1) ? typeValidator(args, 'number') ? Math.log(args) : new Error('no of arguments not valid') : new Error('arguments not valid');
        } catch (err) {
            //alert(err);
        }
    },

    sin: (...args) => {
        try {
            return argumentsValidator(args, 1, 1) ? typeValidator(args, 'number') ? Math.sin(args) : new Error('no of arguments not valid') : new Error('arguments not valid');
        } catch (err) {
            //alert(err);
        }
    },
    cos: (...args) => {
        try {
            return argumentsValidator(args, 1, 1) ? typeValidator(args, 'number') ? Math.cos(args) : new Error('no of arguments not valid') : new Error('arguments not valid');
        } catch (err) {
            //alert(err);
        }
    },
    tan: (...args) => {
        try {
            return argumentsValidator(args, 1, 1) ? typeValidator(args, 'number') ? Math.tan(args) : new Error('no of arguments not valid') : new Error('arguments not valid');
        } catch (err) {
            //alert(err);
        }
    },
    xToPowerY: (...args) => {
        try {
            return argumentsValidator(args, 2, 2) ? typeValidator(args, 'number') ? Math.pow(args[0], args[1]) : new Error('no of arguments not valid') : new Error('arguments not valid')
        } catch (err) {
            //alert(err);
        }
    },
    areaOfCircle: (...args) => {
        return calculatorManager([4, 3.14, ...args], '*', 3, 3);
    }


}

console.log(calculator.addition(2, 5));

console.log(calculator.multiplication(2, 5));
console.log(calculator.subtraction(2, 5));
console.log(calculator.division(2, 7, 5, 0));
console.log(calculator.modulus(70, 5));

// I am assuming maximum arguments should be 5
