import { useEffect, useState } from 'react';
import ChartComponent from './chart/ChartComponent';

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
  const [filter, setFilter] = useState({ modelo: '', hostname: '' });
  const [data, setData] = useState<{ content: DataItem[] }>({ content: [] });

  useEffect(() => {
    fetch('http://localhost:8081/switches')
      .then((response) => response.json())
      .then((data) => setData(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  const handleFilterChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFilter((prev) => ({ ...prev, [name]: value }));
  };

  return (
    <div>
      <input
        type="text"
        name="modelo"
        placeholder="Filtrar por modelo"
        value={filter.modelo}
        onChange={handleFilterChange}
      />
      <input
        type="text"
        name="hostname"
        placeholder="Filtrar por hostname"
        value={filter.hostname}
        onChange={handleFilterChange}
      />
      <ChartComponent data={data} filter={filter} />
    </div>
  );
};

export default App;