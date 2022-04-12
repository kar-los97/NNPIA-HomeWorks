import axiosLib from "axios";

const axios = axiosLib.create({
    baseURL: "http://localhost:8080/task",
    headers: {
        'Content-Type': 'application/json'
    }
})

export function addTask(data,after,afterError){
    axios.post("/",data)
        .then(response=>after(response.data))
        .catch(error=>afterError(error))
}

export function updateTask(id,data,after,afterError) {
    axios.put("/"+id,data)
        .then(response =>after(response.data))
        .catch(error=>afterError(error));

}

export function deleteTask(id,after,afterError){
    axios.delete("/"+id)
        .then(response=>after(response.data))
        .catch(error=>afterError(error))
}

export function getTasks(after,afterError){
    axios.get("/")
        .then(response=>after(response.data))
        .catch(error=>afterError(error))
}

export function getTaskById(id,after,afterError){
    axios.get("/"+id)
        .then(response=>after(response.data))
        .catch(error=>afterError(error))
}