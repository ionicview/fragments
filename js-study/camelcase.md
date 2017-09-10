```
    // jQuery 中的camelCase
    // Matches dashed string for camelizing
    rdashAlpha = /-([a-z]|[0-9])/ig,
    rmsPrefix = /^-ms-/,

    // Used by jQuery.camelCase as callback to replace()
    fcamelCase = function( all, letter ) {
        return ( letter + "" ).toUpperCase();
    },

    camelCase: function( string ) {
        return string.replace( rmsPrefix, "ms-" ).replace( rdashAlpha, fcamelCase );
    }
```
```
  // self study
  // define reg rdashAlpha "-"
  rdashAlpha = /-([a-z]|[0-9])/ig;
  // define callback function
  fcamelCase = function( all, letter ) {
      return ( letter + "" ).toUpperCase();
  }
  // define function for use
  jQuery.extend( {
    camelCase: function( string ) {
        return string.replace( rdashAlpha, fcamelCase );
    },
  }
```
<p align="center">
  <a href="#">
    <img src="https://github.com/chenwb47/io/blob/master/image/jquery-string-replace.png?raw=true">
  </a>
</p>
