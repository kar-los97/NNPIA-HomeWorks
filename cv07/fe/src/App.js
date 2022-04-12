import React, {useEffect, useState} from "react";
import {Field, Form} from "react-final-form";
import './App.css';
import {addTask, deleteTask, getTasks, updateTask} from "./Actions";

const App = () => {
    let [tasks, setTasks] = useState([]);


    useEffect(() => {
        reloadTasks();
    }, []);

    const reloadTasks = () => {
        getTasks((response)=> {
            setTasks(response)
        },(error)=>{
            alert("Chyba při načítání tasků! \n"+JSON.stringify(error))
        })
    }


    const addOnClick = (values)=>{
        values.complete=false;
        addTask(values,(response)=>{
            alert("Task přidán!");
            reloadTasks();
        },(error)=>{
            alert("Nastala chyba: \n"+JSON.stringify(error));
        });
    }

    const completeOrRevertOnClick=(id,complete)=>{
        updateTask(id,{complete:!complete},(data)=>{
            alert(data.complete ? "Task byl označen za hotový" : "Task byl vrácen zpět");
            reloadTasks();
        },(error)=>{
            alert("Nastala chyba: \n"+JSON.stringify(error));
        });
    }

    const deleteOnClick=(id)=>{
        deleteTask(id,(data)=>{
            alert("Task byl vymazán \n"+JSON.stringify(data));
            reloadTasks();
        },(error)=>{
            alert("Nastala chyba: \n"+JSON.stringify(error))
        })
    }

    return (<div>
        <section className={"widget"}>
            <Form onSubmit={addOnClick}
                  validate={values => {
                      let errors = {};
                      if (!values.name) {
                          errors.name = "Zadejte název";
                      }
                      return errors;
                  }}
                  render={({handleSubmit}) => (
                      <>
                          <Field name={"name"}>
                              {({input, meta}) => (
                                  <>
                                      <span>Název:</span>
                                      <input
                                          {...input}
                                          name={"name"}
                                          type={"text"}
                                          className={"form-input"}
                                          placeholder={"Zadejte název"}
                                      />
                                      {meta.error && meta.touched && <span className={"form-error"}>{meta.error}</span>}
                                  </>
                              )}
                          </Field>
                          <button className={"button-form"} type={"submit"} onClick={handleSubmit}
                                  name={"btnSubmit"}>Přidat
                          </button>

                      </>
                  )}
            />
        </section>
        <a href={"https://github.com/kar-los97/nnpia-web-page/tree/master"}>Link to GITHUB</a>
        <Tasks tasks={tasks} onChangeClick={completeOrRevertOnClick} onDeleteClick={deleteOnClick}/>
    </div>)
}

const Task = (props) => (
    <tr>
        <td>{props.task.name}</td>
        <td>
            <button
                onClick={() => props.onChangeClick(props.task.id,props.task.complete)}>{props.task.complete ? "Vrátit zpět" : "Hotovo"}</button>
        </td>
        <td>
            <button
                onClick={() => props.onDeleteClick(props.task.id)}>{"Odstranit"}</button>
        </td>
    </tr>
)

const Tasks = (props) => (
    <>
        <section className={"widget"}>
            <h1>Naplánované tasky</h1>
            <table className={"table-striped"}>
                {props.tasks.filter(item => !item.complete).map((filteretItem, index) => <Task task={filteretItem}
                                                                                               onDeleteClick={props.onDeleteClick}
                                                                                               onChangeClick={props.onChangeClick}
                                                                                               key={index.toString()}/>)}
            </table>
        </section>
        <section className={"widget"}>
            <h1>Hotové tasky</h1>
            <table className={"table-striped"}>
                {props.tasks.filter(item => item.complete).map((filteretItem, index) => <Task task={filteretItem}
                                                                                              onDeleteClick={props.onDeleteClick}
                                                                                              onChangeClick={props.onChangeClick}
                                                                                              key={index.toString()}/>)}
            </table>
        </section>
    </>
)


export default App;
