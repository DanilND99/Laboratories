function octalConvertion(x){
    var result = "";
    while(x >= 8){
        var decimalPart;
        var intPart;
        decimalPart = x/8;
        intPart = parseInt(decimalPart);
        decimalPart = intPart - decimalPart;
        decimalPart *= 8;
        result = "" + decimalPart + result;
        x = intPart;
    }
    result = "" + x + result;
    return result.valueOf();
}
exports.octalConvertion = octalConvertion;