import { useEffect, useState } from 'react';
import ChartComponent from './chart/ChartComponent';
import './App.css';
import PieChartComponent from './chart/PieChartComponent';

interface DataItem {
  registro: number;
  data: string;
  hora: string;
  hostname: string;
  ipAddress: string;
  macAddress: string;
  marca: string;
  modelo: string;
  numSerie: string;
  versao: string;
  imobilizado: string;
}

const App: React.FC = () => {
  const [data1, setData1] = useState<DataItem[]>([]);
  const [data2, setData2] = useState<DataItem[]>([]);
  const [data3, setData3] = useState<DataItem[]>([]);
  const [data4, setData4] = useState<DataItem[]>([]);
  const [data5, setData5] = useState<DataItem[]>([]);
  const [data6, setData6] = useState<DataItem[]>([]);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=Hirschmann')
      .then((response) => response.json())
      .then((data) => setData1(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=Edge-Core')
      .then((response) => response.json())
      .then((data) => setData2(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=Cisco')
      .then((response) => response.json())
      .then((data) => setData3(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=HP')
      .then((response) => response.json())
      .then((data) => setData4(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=SMC')
      .then((response) => response.json())
      .then((data) => setData5(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  useEffect(() => {
    fetch('http://localhost:8081/switches/marca=Rockwell')
      .then((response) => response.json())
      .then((data) => setData6(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  return (
    <>
      <div className="container">
          <header>
            <img src="https://lp.unipar.br/wp-content/uploads/2024/01/unipar.png" alt="Unipar Logo" className="logo" />
            <span>Bem-vindo ao Dashboard</span>
          </header>

        </div>
      <div className="chart-container">
        <ChartComponent data={data1} />
        <ChartComponent data={data2} />
        <ChartComponent data={data3} />
        <ChartComponent data={data4} />
        <ChartComponent data={data5} />
        <ChartComponent data={data6} />
        <div className="footer">
          Copyright © 2024
        </div>
      </div>
    </>
  );
};

export default App;
