// Define the add function
const add = (a: number, b: number): number => a + b;

// Define loggerWrapper function
const loggerWrapper = (func: Function) => {
    // Return a new function that wraps around 'func'
    return (...args: any[]) => {
        // Log the function call
        console.log(`Calling function ${func.name} with arguments: ${args.join(', ')}`);
        // Call the original function and return its result
        return func(...args);
    };
};

// Wrap the 'add' function with loggerWrapper
const loggedAdd = loggerWrapper(add);

// Call the wrapped function
const value2 = loggedAdd(3, 5); // This will log: "Calling function add with arguments: 3, 5"

// Output the result
console.log(`Result: ${value2}`); // Output: "Result: 8"
