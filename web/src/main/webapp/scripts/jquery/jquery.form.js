(function(b){b.fn.ajaxSubmit=function(t){if(!this.length){a("ajaxSubmit: skipping submit process - no element selected");return this}if(typeof t=="function"){t={success:t}}var h=this.attr("action");var d=(typeof h==="string")?b.trim(h):"";if(d){d=(d.match(/^([^#]+)/)||[])[1]}d=d||window.location.href||"";t=b.extend(true,{url:d,success:b.ajaxSettings.success,type:this[0].getAttribute("method")||"GET",iframeSrc:/^https/i.test(window.location.href||"")?"javascript:false":"about:blank"},t);var u={};this.trigger("form-pre-serialize",[this,t,u]);if(u.veto){a("ajaxSubmit: submit vetoed via form-pre-serialize trigger");return this}if(t.beforeSerialize&&t.beforeSerialize(this,t)===false){a("ajaxSubmit: submit aborted via beforeSerialize callback");return this}var f,p,m=this.formToArray(t.semantic);if(t.data){t.extraData=t.data;for(f in t.data){if(t.data[f] instanceof Array){for(var i in t.data[f]){m.push({name:f,value:t.data[f][i]})}}else{p=t.data[f];p=b.isFunction(p)?p():p;m.push({name:f,value:p})}}}if(t.beforeSubmit&&t.beforeSubmit(m,this,t)===false){a("ajaxSubmit: submit aborted via beforeSubmit callback");return this}this.trigger("form-submit-validate",[m,this,t,u]);if(u.veto){a("ajaxSubmit: submit vetoed via form-submit-validate trigger");return this}var c=b.param(m);if(t.type.toUpperCase()=="GET"){t.url+=(t.url.indexOf("?")>=0?"&":"?")+c;t.data=null}else{t.data=c}var s=this,l=[];if(t.resetForm){l.push(function(){s.resetForm()})}if(t.clearForm){l.push(function(){s.clearForm()})}if(!t.dataType&&t.target){var r=t.success||function(){};l.push(function(n){var k=t.replaceTarget?"replaceWith":"html";b(t.target)[k](n).each(r,arguments)})}else{if(t.success){l.push(t.success)}}t.success=function(w,n,x){var v=t.context||t;for(var q=0,k=l.length;q<k;q++){l[q].apply(v,[w,n,x||s,s])}};var g=b("input:file",this).length>0;var e="multipart/form-data";var j=(s.attr("enctype")==e||s.attr("encoding")==e);if(t.iframe!==false&&(g||t.iframe||j)){if(t.closeKeepAlive){b.get(t.closeKeepAlive,o)}else{o()}}else{b.ajax(t)}this.trigger("form-submit-notify",[this,t]);return this;function o(){var v=s[0];if(b(":input[name=submit],:input[id=submit]",v).length){alert('Error: Form elements must not have name or id of "submit".');return}var B=b.extend(true,{},b.ajaxSettings,t);B.context=B.context||B;var E="jqFormIO"+(new Date().getTime()),z="_"+E;var w=b('<iframe id="'+E+'" name="'+E+'" src="'+B.iframeSrc+'" />');var A=w[0];w.css({position:"absolute",top:"-1000px",left:"-1000px"});var x={aborted:0,responseText:null,responseXML:null,status:0,statusText:"n/a",getAllResponseHeaders:function(){},getResponseHeader:function(){},setRequestHeader:function(){},abort:function(){a("aborting upload...");var n="aborted";this.aborted=1;w.attr("src",B.iframeSrc);x.error=n;B.error&&B.error.call(B.context,x,"error",n);I&&b.event.trigger("ajaxError",[x,B,n]);B.complete&&B.complete.call(B.context,x,"error")}};var I=B.global;if(I&&!b.active++){b.event.trigger("ajaxStart")}if(I){b.event.trigger("ajaxSend",[x,B])}if(B.beforeSend&&B.beforeSend.call(B.context,x,B)===false){if(B.global){b.active--}return}if(x.aborted){return}var H=0;var y=v.clk;if(y){var F=y.name;if(F&&!y.disabled){B.extraData=B.extraData||{};B.extraData[F]=y.value;if(y.type=="image"){B.extraData[F+".x"]=v.clk_x;B.extraData[F+".y"]=v.clk_y}}}function G(){var O=s.attr("target"),M=s.attr("action");v.setAttribute("target",E);if(v.getAttribute("method")!="POST"){v.setAttribute("method","POST")}if(v.getAttribute("action")!=B.url){v.setAttribute("action",B.url)}if(!B.skipEncodingOverride){s.attr({encoding:"multipart/form-data",enctype:"multipart/form-data"})}if(B.timeout){setTimeout(function(){H=true;D()},B.timeout)}var N=[];try{if(B.extraData){for(var P in B.extraData){N.push(b('<input type="hidden" name="'+P+'" value="'+B.extraData[P]+'" />').appendTo(v)[0])}}w.appendTo("body");A.attachEvent?A.attachEvent("onload",D):A.addEventListener("load",D,false);v.submit()}finally{v.setAttribute("action",M);if(O){v.setAttribute("target",O)}else{s.removeAttr("target")}b(N).remove()}}if(B.forceSync){G()}else{setTimeout(G,10)}var K,L,J=50;function D(){if(x.aborted){return}var R=A.contentWindow?A.contentWindow.document:A.contentDocument?A.contentDocument:A.document;if(!R||R.location.href==B.iframeSrc){if(!H){return}}A.detachEvent?A.detachEvent("onload",D):A.removeEventListener("load",D,false);var N=true;try{if(H){throw"timeout"}var S=B.dataType=="xml"||R.XMLDocument||b.isXMLDoc(R);a("isXml="+S);if(!S&&window.opera&&(R.body==null||R.body.innerHTML=="")){if(--J){a("requeing onLoad callback, DOM not available");setTimeout(D,250);return}}x.responseText=R.body?R.body.innerHTML:R.documentElement?R.documentElement.innerHTML:null;x.responseXML=R.XMLDocument?R.XMLDocument:R;x.getResponseHeader=function(U){var T={"content-type":B.dataType};return T[U]};var Q=/(json|script)/.test(B.dataType);if(Q||B.textarea){var M=R.getElementsByTagName("textarea")[0];if(M){x.responseText=M.value}else{if(Q){var P=R.getElementsByTagName("pre")[0];var n=R.getElementsByTagName("body")[0];if(P){x.responseText=P.textContent}else{if(n){x.responseText=n.innerHTML}}}}}else{if(B.dataType=="xml"&&!x.responseXML&&x.responseText!=null){x.responseXML=C(x.responseText)}}K=k(x,B.dataType,B)}catch(O){a("error caught:",O);N=false;x.error=O;B.error&&B.error.call(B.context,x,"error",O);I&&b.event.trigger("ajaxError",[x,B,O])}if(x.aborted){a("upload aborted");N=false}if(N){B.success&&B.success.call(B.context,K,"success",x);I&&b.event.trigger("ajaxSuccess",[x,B])}I&&b.event.trigger("ajaxComplete",[x,B]);if(I&&!--b.active){b.event.trigger("ajaxStop")}B.complete&&B.complete.call(B.context,x,N?"success":"error");setTimeout(function(){w.removeData("form-plugin-onload");w.remove();x.responseXML=null},100)}var C=b.parseXML||function(n,M){if(window.ActiveXObject){M=new ActiveXObject("Microsoft.XMLDOM");M.async="false";M.loadXML(n)}else{M=(new DOMParser()).parseFromString(n,"text/xml")}return(M&&M.documentElement&&M.documentElement.nodeName!="parsererror")?M:null};var q=b.parseJSON||function(n){return window["eval"]("("+n+")")};var k=function(Q,O,N){var M=Q.getResponseHeader("content-type")||"",n=O==="xml"||!O&&M.indexOf("xml")>=0,P=n?Q.responseXML:Q.responseText;if(n&&P.documentElement.nodeName==="parsererror"){b.error&&b.error("parsererror")}if(N&&N.dataFilter){P=N.dataFilter(P,O)}if(typeof P==="string"){if(O==="json"||!O&&M.indexOf("json")>=0){P=q(P)}else{if(O==="script"||!O&&M.indexOf("javascript")>=0){b.globalEval(P)}}}return P}}};b.fn.ajaxForm=function(c){if(this.length===0){var d={s:this.selector,c:this.context};if(!b.isReady&&d.s){a("DOM not ready, queuing ajaxForm");b(function(){b(d.s,d.c).ajaxForm(c)});return this}a("terminating; zero elements found by selector"+(b.isReady?"":" (DOM not ready)"));return this}return this.ajaxFormUnbind().bind("submit.form-plugin",function(f){if(!f.isDefaultPrevented()){f.preventDefault();b(this).ajaxSubmit(c)}}).bind("click.form-plugin",function(j){var i=j.target;var g=b(i);if(!(g.is(":submit,input:image"))){var f=g.closest(":submit");if(f.length==0){return}i=f[0]}var h=this;h.clk=i;if(i.type=="image"){if(j.offsetX!=undefined){h.clk_x=j.offsetX;h.clk_y=j.offsetY}else{if(typeof b.fn.offset=="function"){var k=g.offset();h.clk_x=j.pageX-k.left;h.clk_y=j.pageY-k.top}else{h.clk_x=j.pageX-i.offsetLeft;h.clk_y=j.pageY-i.offsetTop}}}setTimeout(function(){h.clk=h.clk_x=h.clk_y=null},100)})};b.fn.ajaxFormUnbind=function(){return this.unbind("submit.form-plugin click.form-plugin")};b.fn.formToArray=function(q){var p=[];if(this.length===0){return p}var d=this[0];var g=q?d.getElementsByTagName("*"):d.elements;if(!g){return p}var k,h,f,r,e,m,c;for(k=0,m=g.length;k<m;k++){e=g[k];f=e.name;if(!f){continue}if(q&&d.clk&&e.type=="image"){if(!e.disabled&&d.clk==e){p.push({name:f,value:b(e).val()});p.push({name:f+".x",value:d.clk_x},{name:f+".y",value:d.clk_y})}continue}r=b.fieldValue(e,true);if(r&&r.constructor==Array){for(h=0,c=r.length;h<c;h++){p.push({name:f,value:r[h]})}}else{if(r!==null&&typeof r!="undefined"){p.push({name:f,value:r})}}}if(!q&&d.clk){var l=b(d.clk),o=l[0];f=o.name;if(f&&!o.disabled&&o.type=="image"){p.push({name:f,value:l.val()});p.push({name:f+".x",value:d.clk_x},{name:f+".y",value:d.clk_y})}}return p};b.fn.formSerialize=function(c){return b.param(this.formToArray(c))};b.fn.fieldSerialize=function(d){var c=[];this.each(function(){var h=this.name;if(!h){return}var f=b.fieldValue(this,d);if(f&&f.constructor==Array){for(var g=0,e=f.length;g<e;g++){c.push({name:h,value:f[g]})}}else{if(f!==null&&typeof f!="undefined"){c.push({name:this.name,value:f})}}});return b.param(c)};b.fn.fieldValue=function(h){for(var g=[],e=0,c=this.length;e<c;e++){var f=this[e];var d=b.fieldValue(f,h);if(d===null||typeof d=="undefined"||(d.constructor==Array&&!d.length)){continue}d.constructor==Array?b.merge(g,d):g.push(d)}return g};b.fieldValue=function(c,j){var e=c.name,p=c.type,q=c.tagName.toLowerCase();if(j===undefined){j=true}if(j&&(!e||c.disabled||p=="reset"||p=="button"||(p=="checkbox"||p=="radio")&&!c.checked||(p=="submit"||p=="image")&&c.form&&c.form.clk!=c||q=="select"&&c.selectedIndex==-1)){return null}if(q=="select"){var k=c.selectedIndex;if(k<0){return null}var m=[],d=c.options;var g=(p=="select-one");var l=(g?k+1:d.length);for(var f=(g?k:0);f<l;f++){var h=d[f];if(h.selected){var o=h.value;if(!o){o=(h.attributes&&h.attributes.value&&!(h.attributes.value.specified))?h.text:h.value}if(g){return o}m.push(o)}}return m}return b(c).val()};b.fn.clearForm=function(){return this.each(function(){b("input,select,textarea",this).clearFields()})};b.fn.clearFields=b.fn.clearInputs=function(){return this.each(function(){var d=this.type,c=this.tagName.toLowerCase();if(d=="text"||d=="password"||c=="textarea"){this.value=""}else{if(d=="checkbox"||d=="radio"){this.checked=false}else{if(c=="select"){this.selectedIndex=-1}}}})};b.fn.resetForm=function(){return this.each(function(){if(typeof this.reset=="function"||(typeof this.reset=="object"&&!this.reset.nodeType)){this.reset()}})};b.fn.enable=function(c){if(c===undefined){c=true}return this.each(function(){this.disabled=!c})};b.fn.selected=function(c){if(c===undefined){c=true}return this.each(function(){var d=this.type;if(d=="checkbox"||d=="radio"){this.checked=c}else{if(this.tagName.toLowerCase()=="option"){var e=b(this).parent("select");if(c&&e[0]&&e[0].type=="select-one"){e.find("option").selected(false)}this.selected=c}}})};function a(){if(b.fn.ajaxSubmit.debug){var c="[jquery.form] "+Array.prototype.join.call(arguments,"");if(window.console&&window.console.log){window.console.log(c)}else{if(window.opera&&window.opera.postError){window.opera.postError(c)}}}}})(jQuery);