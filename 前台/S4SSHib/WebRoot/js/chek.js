/*
��;����������ֻ������Ƿ���ȷ
���룺
s���ַ���
���أ�
���ͨ����֤����true,���򷵻�false
*/
function checkMobile(s) {
var regu = /^[1][0-9][0-9]{9}$/;
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
} 

/*
��;�������������ֵ�Ƿ����E-Mail��ʽ
���룺str ������ַ���
���أ����ͨ����֤����true,���򷵻�false
*/
function isEmail(str) {
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
if (myReg.test(str)) return true;
return false;
} 

function chekUserName(str,div){

   var flag=false;
   var str= document.all(str);
   var div=document.all(div);
  
   if(str.value.length<=0){
     div.innerHTML="<font color='red'>�û���(�ֻ���)����Ϊ��</font>";
    div.style.display="inline";
   }
   else{
      if(checkMobile(str.value)){
         flag=true;
        
          div.style.display="none";
      }
      else{
       div.innerHTML="<font color='red'>��������ȷ���ֻ���</font>";
    div.style.display="inline";
      }
   }
   return flag;
   }
   function chekUserPwd(str,div){
   var flag=false;
 var userpwd=  document.all(str);
 var div=  document.all(div);
   if(userpwd.value.length<=0){
   div.innerHTML="<font color='red'>���벻��Ϊ��</font>";
    div.style.display="inline";
   }
    else{
    flag=true;
    div.style.display="none";
    }
    return flag;
   }
   function chekYzm(str,str1,div){
   var flag=false;
   var str=  document.all(str);
   var str1=  document.all(str1);
   var div=  document.all(div);
   if(str.value.length<=0){
   div.innerHTML="<font color='red'>��֤�벻��Ϊ��</font>";
    div.style.display="inline";
   }
   else{
   
   if(str.value==str1.value){
   flag=true;
   }
   else{
   div.innerHTML="<font color='red'>��֤���������</font>";
    div.style.display="inline";
   }
   }
   return flag;
   }
   function chekLogin(str,str1,str2,str3,div,div1,div2){
    var flag=false;
    if(chekUserName(str,div)&&chekUserPwd(str1,div1)&&chekYzm(str2,str3,div2)){
    flag=true;
    }
    return flag;
   }
   
/*
��;����������ַ����Ƿ�ֻ�ɺ������
���룺
s���ַ���
���أ�
���ͨ����֤����true,���򷵻�false
*/

function isZh(str){
 var reg = /^[\u4e00-\u9fa5]+$/;
 if (reg.test(str)) return true;
 return false; 
} 
    function chekName(str,div){
    var flag=false;
     var str=document.all(str)
      var div=document.all(div)
     if(str.value.length<=0){
         div.innerHTML="<font color='red'>��������Ϊ��</font>";
    div.style.display="inline";
     } 
     else{
     
     if(isZh(str.value)){
     flag=true;
      div.style.display="none";
     }
     else{
        div.innerHTML="<font color='red'>��������ȷ������</font>";
    div.style.display="inline";
     }
     
     }
    return flag;
    }
   
   function chekReg(str,str1,str2,str3,str4,div,div1,div2,div3){
   var flag=false;
     if(chekUserName(str,div)&&chekName(str4,div3)&&chekUserPwd(str1,div1)&&chekYzm(str2,str3,div2)){
    flag=true;
    }
    return flag;
   }
    </script>