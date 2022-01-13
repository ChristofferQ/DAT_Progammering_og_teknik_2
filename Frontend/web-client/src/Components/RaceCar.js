import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const RaceCar = () => {
    const [raceCarList, setRaceCarList] = useState([]);
    useEffect(() => {
        facade.fetchData("racecar")
            .then(data => {
                setRaceCarList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List of Cars in Races</h2>
            <h4>Races</h4>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Location</th>
                </tr>
                </thead>
                <tbody>
                {
                    raceCarList.map((race, index) => (
                        <tr>
                            <td>{race.id}</td>
                            <td>{race.name}</td>
                            <td>{race.date}</td>
                            <td>{race.time}</td>
                            <td>{race.location}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
            <h4>Cars</h4>
                <table className="table mt-4">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Brand</th>
                    <th>Make</th>
                    <th>Year</th>
                </tr>
                </thead>
                <tbody>
                {
                    raceCarList.map((car, index) => (
                        <tr>
                            <td>{car.id}</td>
                            <td>{car.brand}</td>
                            <td>{car.make}</td>
                            <td>{car.year}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}

export default RaceCar;