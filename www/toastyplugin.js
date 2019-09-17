/*var exec = require('cordova/exec');

exports.show = function (arg0, success, error) {
    exec(success, error, 'ToastyPlugin', 'show', [arg0]);
};
*/

// Constructor vacío
function ToastyPlugin() {}

// recibir los datos
//ToastyPlugin.prototype.show = function(message, successCallback, errorCallback) {
ToastyPlugin.prototype.show = function(arg0, successCallback, errorCallback) {
  //var options = {};
  //options.message = message;
  //cordova.exec(successCallback, errorCallback, 'ToastyPlugin', 'show', [options]);
  cordova.exec(successCallback, errorCallback, 'ToastyPlugin', 'show', [arg0]);
}

 // Instalar la variable en el window
ToastyPlugin.install = function() {
  if (!window.plugins) {
    window.plugins = {};
  }
  window.plugins.toastyPlugin = new ToastyPlugin();
  return window.plugins.toastyPlugin;
};
cordova.addConstructor(ToastyPlugin.install);


