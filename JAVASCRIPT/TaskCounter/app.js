let count=0;
const countVal=document.getElementById("count")
const incbtn =document.getElementById("inc")
const decbtn=document.getElementById("dec")
const resetbtn =document.getElementById("reset")
incbtn.addEventListener("click",()=>{
    count++;
    countVal.textContent = count;
})

decbtn.addEventListener("click",()=>{
    count--;
    countVal.textContent=count;
})


resetbtn.addEventListener("click",()=>{
    count=0;
    countVal.textContent=count;
})
