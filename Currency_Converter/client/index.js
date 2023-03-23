const amountInput = document.getElementById("amount")
const result = document.getElementById("result")
const baseSelect = document.getElementById("base")
const toSelect = document.getElementById("to")
const convert = document.getElementById("convert")


convert.onclick = (e)=>{
    e.preventDefault() 
    result.textContent = "..."
    const base = baseSelect.value // USD
    const to = toSelect.value // TRY
    const amount = amountInput.value
    if(base === to){
        result.textContent = amount;
    }
    else{
        let url = "http://localhost/"
        if(base === "TRY" && to === "USD"){
            url += "tl-dolar?amount="+amount
        }
        else if(base==="USD" && to === "TRY"){
            url += "tl-dolar?amount="+amount+"&direction=1"
        }
        else if(base === "TRY" && to === "EUR"){
            url += "tl-euro?amount="+amount
        }
        else if(base==="EUR" && to === "TRY"){
            url += "tl-euro?amount="+amount+"&direction=1"
        }
        else if(base === "USD" && to === "EUR"){
            url += "dolar-euro?amount="+amount
        }
        else if(base==="EUR" && to === "USD"){
            url += "dolar-euro?amount="+amount+"&direction=1"
        }
        axios.get(url)
        .then(res=>{
            console.log(res.data);
            result.textContent = res.data.converted
        })
        .catch(err=>{
            console.log(err);
            result.textContent = "Error"
        })
    }
}