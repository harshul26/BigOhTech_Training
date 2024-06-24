let calculator = (operation, ...number) => {
    return operation(number);
};

let addition = (numbers) => {
    return numbers.reduce((sum, i) => {
        try {
            if (typeof(i) !== "number") {
                throw ("Not a valid number");
            }
            sum + i;
        } catch (err) {
            alert(err);
        }

    });
}

let subtraction = (numbers) => {
    try {
        if (numbers.length != 2) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number" || numbers[1] !== "number")) {
            new Error("Not a valid number");
        }
        return numbers[0] - numbers[1];
    } catch (err) {
        alert(err);
    }
}

let multiplication = (numbers) => {
    return numbers.reduce((product, i) => {
        try {
            if (typeof(i) !== "number") {
                throw ("Not a valid number");
            }
            product * i;
        } catch (err) {
            alert(err);
        }
    });
}

let division = (numbers) => {
    try {
        if (numbers.length != 2) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number" || typeof(numbers[1] !== "number"))) {
            throw ("Not a valid number");
        }
        return numbers[0] / numbers[1];
    } catch (err) {
        alert(err);
    }
}

let square = (numbers) => {

    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return numbers[0] * numbers[0];
    } catch (err) {
        alert(err);
    }

}

let squareRoot = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
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
    } catch (err) {
        alert(err);
    }

}

let log = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs");
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return Math.log10(number);
    } catch (err) {
        alert(err);
    }

}

let ln = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return Math.log(number);
    } catch (err) {
        alert(err);
    }

}

let sin = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return Math.sin(number);
    } catch (err) {
        alert(err);
    }

}

let cos = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return Math.cos(number);
    } catch (err) {
        alert(err);
    }


}

let tan = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return Math.tan(number);
    } catch (err) {
        alert(err);
    }

}

let power = (numbers) => {
    try {
        if (numbers.length != 2) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number" || typeof(numbers[1] !== "number"))) {
            throw ("Not a valid number");
        }
        return Math.pow(numbers[0], numbers[1]);
    } catch (err) {
        alert(err);
    }


}

let areaOfCircle = (radius) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return (4 * 3.14 * square(radius[0]));
    } catch (err) {
        alert(err);
    }
}

let areaOfSquare = (side) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return;
    } catch (err) {
        alert(err);
    }
}



let celsiusToFahrenheit = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return (((9 / 5) * numbers[0]) + 32);
    } catch (err) {
        alert(err);
    }
}

let fahrenheitToCelsius = (numbers) => {
    try {
        if (numbers.length != 1) {
            throw ("You have entered too many inputs")
        } else if (typeof(numbers[0] !== "number")) {
            throw ("Not a valid number");
        }
        return ((numbers[0] - 32) * (5 / 9));
    } catch (err) {
        alert(err);
    }
}

console.log(calculator(square, 2));
