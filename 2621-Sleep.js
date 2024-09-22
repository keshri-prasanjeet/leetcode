/**
 * LeetCode 2621: Sleep
 * 
 * Key Concepts:
 * 1. Asynchronous JavaScript: JS is single-threaded but can handle async operations.
 * 2. Promises: Objects representing the eventual completion or failure of an async operation.
 * 3. async/await: Syntactic sugar built on top of Promises for easier async code.
 * 4. setTimeout: A built-in function that executes code after a specified delay.
 * 5. <----$$$$An async function always returns a promise$$$$---->
 * 
 * Solution Breakdown:
 * - We use an async function to implicitly return a Promise.
 * - Inside, we create a new Promise that resolves after the specified time.
 * - We use setTimeout to delay the resolution of the Promise.
 * - The resolve function is passed directly as the callback to setTimeout.
 * 
 * Note on Promise syntax:
 * - Typically, Promises use both resolve and reject parameters.
 * - In this case, we only use resolve as there's no error condition to handle.
 * - For simple cases like this, using only resolve is acceptable and cleaner.
 * 
 * Why setTimeout takes resolve as a parameter:
 * - The first parameter of setTimeout is a function that will be executed after the specified delay. This is often called a callback function.
 * - By passing resolve, we're telling setTimeout to resolve the Promise after the delay.
 * - This bridges the callback-based setTimeout with the Promise-based async/await syntax.
 * 
 * @param {number} millis - The number of milliseconds to sleep.
 * @return {Promise} A promise that resolves after the specified time.
 */
async function sleep(millis) {
    return new Promise(resolve => setTimeout(resolve, millis));
}

// Example usage:
// async function example() {
//     console.log("Start");
//     await sleep(2000);  // Waits for 2 seconds
//     console.log("End");
// }
// 
// example();