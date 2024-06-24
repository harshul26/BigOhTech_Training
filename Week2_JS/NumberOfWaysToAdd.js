// Javascript Program to implement 
// the above approach

// Function to call dfs() to
// calculate the number of ways
function findWays(nums, targetSum) {
    return dfs(nums, targetSum, 0, 0);
}


// Function to count the number of ways
function dfs(nums, targetSum, curr_sum, index) {
    // Base Case: Reached the
    // end of the array
    if (index == nums.length) {

        // Sum is equal to the
        // required sum
        if (targetSum == curr_sum)
            return 1;
        else
            return 0;
    }

    if (curr_sum == targetSum) {
        return 1;
    }

    // Recursively check if required sum
    // can be obtained by adding current
    // element or by subtracting the
    // current index element
    return (dfs(nums, targetSum, curr_sum + nums[index], index + 1) +
        dfs(nums, targetSum, curr_sum - nums[index], index + 1) +
        dfs(nums, targetSum, curr_sum, index + 1));
}

let targetSum = 5;
let array = [-1, 9, 8, -3, 4];
console.log(findWays(array, targetSum));
