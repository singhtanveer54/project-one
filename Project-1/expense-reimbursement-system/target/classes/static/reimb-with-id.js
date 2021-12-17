window.addEventListener("load", async () => {
    let res = await fetch(`http://localhost:8080/checkloginstatus`, {
      method: "GET",
      credentials: "include",
    });
  
    if (res.status === 200) {
      let userObj = await res.json();
  
      if (userObj.role === "employee") {
        window.location.href = "employee-homepage.html";
      }
      let fnLn = document.querySelector('#fnLn');
        fnLn.innerHTML = `Welcome ${userObj.firstName} ${userObj.lastName}`; 
  
      console.log("userObj>>>", userObj);
      
  
    } else if (res.status === 401) {
      window.location.href = "index.html";
    }
  });
  
let submitBtn = document.querySelector("#submitBTN");

submitBtn.addEventListener('click', submitButtonClicked);


function submitButtonClicked(){
    reimById();
  
}

async function reimById(){
    let usernameInput = document.querySelector('#userId');
    let statusInput = document.querySelector("#status")
    //let passwordInput = document.querySelector('#password');

    let formData = new FormData();
    formData.append('re_id',usernameInput.value);
    formData.append('status',statusInput.value);
    try{
            let res = await fetch(`http://localhost:8080/reimbursement/status`,{
                method:'PATCH',
                credentials:'include',
                body: formData
                })
             console.log(usernameInput.value);
             console.log(statusInput.value);
            let tbodyElement = document.querySelector("#reimb_table");
            //tbodyElement.innerHTML = "";

            let data = await res.json();
            console.log(data);

            if(res.status===400){
                let loginErrorMessage = document.createElement('p');
                let loginDiv = document.querySelector('#message-div');
                loginDiv.innerHTML=' ';
                loginErrorMessage.innerHTML = data.message;
                loginErrorMessage.style.color = 'red';
                loginDiv.appendChild(loginErrorMessage);

            }else if(res.status===200){
              let tr = document.createElement("tr");
    
              let td1 = document.createElement("td");
              td1.innerHTML = data.id;
          
              let td2 = document.createElement("td");
              td2.innerHTML = data.amount;
          
              let td3 = document.createElement("td");
              td3.innerHTML = data.submitted;
          
              let td4 = document.createElement("td");
              td4.innerHTML = data.resolved;
          
              let td5 = document.createElement("td");
              td5.innerHTML = data.description;
          
              let td6 = document.createElement("td");
              td6.innerHTML = data.aFirstName;
          
              let td7 = document.createElement("td"); //resolverId
              td7.innerHTML = data.rFirstName;
      
              let td8 = document.createElement("td"); // status
              td8.innerHTML = data.status;
      
              let td9 = document.createElement("td");
              td9.innerHTML = data.reimType;
      
              let td10 = document.createElement("td");
              
              let viewImageButton = document.createElement('button');
          viewImageButton.innerHTML = 'View Receipt';
      
          td10.appendChild(viewImageButton);
      
          viewImageButton.addEventListener("click", () => {
            let reimbImageModal = document.querySelector('#reimb-image-modal');
      
            let modalCloseElement = reimbImageModal.querySelector('button');
            modalCloseElement.addEventListener('click', () =>{
                reimbImageModal.classList.remove('is-active');
            });
      
            let modalContentElement = reimbImageModal.querySelector('.modal-content');
            modalContentElement.innerHTML = '';
      
            let imageElement = document.createElement("img");
            imageElement.setAttribute(
              "src",
              `http://localhost:8080/reimbursement/${data.id}/image`
            );
            modalContentElement.appendChild(imageElement);
      
            reimbImageModal.classList.add("is-active");
          })
    
              tr.appendChild(td1);
              tr.appendChild(td2);
              tr.appendChild(td3);
              tr.appendChild(td4);
              tr.appendChild(td5);
              tr.appendChild(td6);
              tr.appendChild(td7);
              tr.appendChild(td8);
              tr.appendChild(td9);
              tr.appendChild(td10);
              
              tbodyElement.appendChild(tr);
                
          }   
        }catch(err){
            console.log(err);
        }
    }
