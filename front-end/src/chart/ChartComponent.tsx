import { useMemo } from 'react';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

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

interface ChartComponentProps {
  data: { content: DataItem[] };
  filter: { modelo: string; hostname: string };
}

const ChartComponent: React.FC<ChartComponentProps> = ({ data, filter }) => {
  const filteredData = useMemo(() => {
    return data.content.filter((item) =>
      item.modelo.includes(filter.modelo)
    );
  }, [data, filter]);

  const chartData = {
    labels: filteredData.map((item) => item.data.split('T')[0]),
    datasets: [
      {
        label: 'Registro',
        data: filteredData.map((item) => item.registro),
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1,
      },
    ],
  };

  return <Bar data={chartData} />;
};

export default ChartComponent;