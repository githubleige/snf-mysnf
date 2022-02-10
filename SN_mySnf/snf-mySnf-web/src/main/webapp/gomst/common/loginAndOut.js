function login(){

   document.cookie = "authId=1; expires=Thu, 01 Jan 1970 00:00:00 UTC; domain=.cnsuning.com; path=/;";

    var newlocationHref =  location.origin + '/ztreport-web/auth?targetUrl=' + location.href;
    if(location.hostname.match('locals') || location.hostname.match('dev')){
       location.href = 'https://ssosit.cnsuning.com/ids/login?loginTheme=snrsdev&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('sit')){
        location.href = 'https://ssosit.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('pre')){
        location.href = 'https://ssopre.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('pst')){
        location.href = 'https://ssopst.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
     else if(location.hostname.match('xgpre')){
        location.href = 'https://ssoprexg.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('poc')){
        location.href = 'https://ssopoca.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
    else{
        location.href = 'https://sso.cnsuning.com/ids/login?loginTheme=snrs&service='+ encodeURIComponent(newlocationHref)
    }
}

function loginOut(){
     //document.cookie = "authId=1; expires=Thu, 01 Jan 1970 00:00:00 UTC; domain=.cnsuning.com; path=/;";

    var newlocationHref =  location.origin+"/ztwfmt"
    if(location.hostname.match('locals') || location.hostname.match('dev')){
       location.href = 'https://ssosit.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('sit')){
        location.href = 'https://ssosit.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('pre')){
        location.href = 'https://ssopre.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('pst')){
        location.href = 'https://ssopst.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
     else if(location.hostname.match('xgpre')){
        location.href = 'https://ssoprexg.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
    else if(location.hostname.match('poc')){
        location.href = 'https://ssopoca.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
    else{
        location.href = 'https://sso.cnsuning.com/ids/logout?loginTheme=rdrs&service='+ encodeURIComponent(newlocationHref)
    }
}

// export {login,loginOut}
