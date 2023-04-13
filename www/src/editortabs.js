switchedTo = ""
buttons = {}
tabs = {}

function init() {
    let elements = document.getElementsByClassName('tabs');
    defaultName = ""
    Object.keys(elements)
    .forEach( (key) => { 
        object = elements[key];
        classes = object.className.split(" ");

        for(let c in classes){
            c = classes[c]
            if(c.startsWith("tabs-button-")){
                all = c.split("-");
                object.onclick = (obj) => {
                    cls = obj.explicitOriginalTarget.className.split(" ")
                    
                    for(let z in cls){
                        z = cls[z];

                        if(c.startsWith("tabs-button-")){
                            all = c.split("-");
                            switchTo(all[2]);
                        }      
                    }
                }

                buttons[all[2]] = object
            }

            if(c.startsWith("tabs-content-")){
                all = c.split("-");
                tabs[all[2]] = object;

                for(let z in classes){
                    z = classes[z]
                    if(z.startsWith("tabs-default"))
                        defaultName = all[2];
                }
            }
        }
    });
    console.log(tabs);
    switchTo(defaultName)
};

function switchTo(name){
    if(switchedTo == name) return;
    switchedTo = name;
    Object.keys(tabs)
    .forEach( (key) => { 
        if(key == name){
            tabs[key].style["display"]="block";
            addClass(buttons[key], "tabs-clicked");
        }
        else{
            tabs[key].style["display"]="none";
            removeClass(buttons[key], "tabs-clicked");
        }
    });
}

function hasClass(ele,cls) {
    return !!ele.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'));
  }

function addClass(ele,cls) {
    if (!hasClass(ele,cls)) ele.className += " "+cls;
  }
  
  function removeClass(ele,cls) {
    if (hasClass(ele,cls)) {
      var reg = new RegExp('(\\s|^)'+cls+'(\\s|$)');
      ele.className=ele.className.replace(reg,' ');
    }
  }

  /* bind body onload for Mozilla/Opera9 */
//   if (document.addEventListener) {
//     document.addEventListener("DOMContentLoaded", init, false);
//   }
  
  /* bind body onload for Internet Explorer */
  /*@cc_on @*/
  /*@if (@_win32)
    document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
    var script = document.getElementById("__ie_onload");
    script.onreadystatechange = function() {
      if (this.readyState == "complete") {
        init(); // call the onload handler
      }
    };
  /*@end @*/
  
  /* bind body onload for Safari */
//   if (/WebKit/i.test(navigator.userAgent)) { // sniff
//     var _timer = setInterval(function() {
//       if (/loaded|complete/.test(document.readyState)) {
//         init(); // call the onload handler
//       }
//     }, 10);
//   }
  
  /* bind body onload for other browsers */
  window.onload = init;