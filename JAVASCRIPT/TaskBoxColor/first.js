const box=document.querySelector(".box");
const btn1=document.querySelector(".btn1");
const btn2=document.querySelector(".btn2");
const btn3=document.querySelector(".btn3");
const btn4=document.querySelector(".btn4");

btn1.addEventListener("click",()=>{
    box.classList.remove("bggreen", "bgred","bgpink","bgyellow")
    box.classList.add("bggreen");
    

})

btn2.addEventListener("click",()=>{
    box.classList.remove("bggreen", "bgred","bgpink","bgyellow")
    box.classList.add("bgred");
    

})

btn3.addEventListener("click",()=>{
    box.classList.remove("bggreen", "bgred","bgpink","bgyellow")
    box.classList.add("bgpink");
    

})

btn4.addEventListener("click",()=>{
    box.classList.remove("bggreen", "bgred","bgpink","bgyellow")
    box.classList.add("bgyellow");
    

})