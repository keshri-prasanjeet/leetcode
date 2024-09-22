/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    const timeoutId = setTimeout(function(){
        return fn(...args);
    }
    , t);//when the cancellable is called in the below commented out code
    // if setTimeout(cancel, cancelTimeMs); cancelTimeMs is longer than the t passed as argument
    // the function() fn(...args) gets enough time to execute
    // else if the t is longer than the cancelTimeMs then when cancellable is called the timeout is still running
    // the code goes to next line and cancels the timeout
    return function(){
        clearTimeout(timeoutId);
    }
};

/**
 *  const result = [];
 *
 *  const fn = (x) => x * 5;
 *  const args = [2], t = 20, cancelTimeMs = 50;
 *
 *  const start = performance.now();
 *
 *  const log = (...argsArr) => {
 *      const diff = Math.floor(performance.now() - start);
 *      result.push({"time": diff, "returned": fn(...argsArr)});
 *  }
 *       
 *  const cancel = cancellable(log, args, t);
 *
 *  const maxT = Math.max(t, cancelTimeMs);
 *           
 *  setTimeout(cancel, cancelTimeMs);
 *
 *  setTimeout(() => {
 *      console.log(result); // [{"time":20,"returned":10}]
 *  }, maxT + 15)
 */