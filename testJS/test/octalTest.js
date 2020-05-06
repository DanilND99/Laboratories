var assert = require('assert');
var javascriptFunctions = require('../octals');
describe('given1ThenReturn1()', function(){
    it('octalConvertion(1) = 1', function(){
        //Given
        var a = 1;
        var expectedResult = 1;
        //When
        var actualResult = javascriptFunctions.octalConvertion(a);
        //Then
        assert.equal(expectedResult, actualResult);
    });
});
describe('given2ThenReturn2()', function(){
    it('octalConvertion(2) = 2', function(){
        //Given
        var a = 2;
        var expectedResult = 2;
        //When
        var actualResult = javascriptFunctions.octalConvertion(a);
        //Then
        assert.equal(expectedResult, actualResult);
    });
});
describe('given8ThenReturn10()', function(){
    it('octalConvertion(8) = 10', function(){
        //Given
        var a = 8;
        var expectedResult = 10;
        //When
        var actualResult = javascriptFunctions.octalConvertion(a);
        //Then
        assert.equal(expectedResult, actualResult);
    });
});
describe('given95ThenReturn137()', function(){
    it('octalConvertion(95) = 137', function(){
        //Given
        var a = 95;
        var expectedResult = 137;
        //When
        var actualResult = javascriptFunctions.octalConvertion(a);
        //Then
        assert.equal(expectedResult, actualResult);
    });
});
describe('given2048ThenReturn4000()', function(){
    it('octalConvertion(2048) = 4000', function(){
        //Given
        var a = 2048;
        var expectedResult = 4000;
        //When
        var actualResult = javascriptFunctions.octalConvertion(a);
        //Then
        assert.equal(expectedResult, actualResult);
    });
});