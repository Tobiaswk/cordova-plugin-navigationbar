var exec = require('cordova/exec');

var NavigationBar = {

  backgroundColorByHexString: function(hexString) {
    if (hexString.charAt(0) !== "#") {
      hexString = "#" + hexString;
    }

    if (hexString.length === 4) {
      var split = hexString.split("");
      hexString = "#" + split[1] + split[1] + split[2] + split[2] + split[3] +
        split[3];
    }

    exec(null, null, "NavigationBar", "backgroundColorByHexString", [
      hexString
    ]);
  },
};

// prime it
exec(function(res) {

}, null, "NavigationBar", "_ready", []);

module.exports = NavigationBar;
