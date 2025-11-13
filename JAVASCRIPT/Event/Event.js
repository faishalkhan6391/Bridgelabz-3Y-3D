function myfunc(){
    console.log("Button has CLicked");
}
let count=0;
function dblclick(){
    count++;
    
    console.log(`btn Cicked ${count}`)
}
const btnEl=document.getElementById("btn")
const boxEl=document.querySelector("btn")

btnEl.addEventListener("click",()=>{
    count  
    boxEl.classList.add() 
    
    console.log(`btn Cicked ${count}`)
})



