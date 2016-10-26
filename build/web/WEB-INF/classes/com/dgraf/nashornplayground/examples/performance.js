function normalPrime(max)
{
    var primes = [];
    //Loop through all numbers
    for(var i = 1; i <= max; i++){
        var isPrime = true;
        for(var j = 2; j < i; j++){
            //If dividible by that number, stop, isn't a prime number
            if(i%j === 0){
                isPrime = false;
                break;
            }
    }
    //If it is, add it to the array
    if(isPrime) 
        primes.push(i);
    }
    return primes;
}

print(normalPrime(10000));