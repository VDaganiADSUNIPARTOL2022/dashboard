import { useMemo } from 'react';
import { Pie } from 'react-chartjs-2';
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';

ChartJS.register(ArcElement, Tooltip, Legend);

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

interface PieChartComponentProps {
  data: DataItem[];
}

const PieChartComponent: React.FC<PieChartComponentProps> = ({ data }) => {
  const aggregatedData = useMemo(() => {
    const dataCountMap = new Map<string, number>();

    data.forEach(item => {
      if (dataCountMap.has(item.data)) {
        dataCountMap.set(item.data, dataCountMap.get(item.data)! + 1);
      } else {
        dataCountMap.set(item.data, 1);
      }
    });

    const labels = Array.from(dataCountMap.keys());
    const values = Array.from(dataCountMap.values());

    return { labels, values };
  }, [data]);

  const chartData = {
    labels: aggregatedData.labels,
    datasets: [
      {
        data: aggregatedData.values,
        backgroundColor: [
          'rgba(75, 192, 192, 0.2)',
          'rgba(255, 99, 132, 0.2)',
          'rgba(255, 159, 64, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 205, 86, 0.2)',
        ],
        borderColor: [
          'rgba(75, 192, 192, 1)',
          'rgba(255, 99, 132, 1)',
          'rgba(255, 159, 64, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 205, 86, 1)',
        ],
        borderWidth: 1,
      },
    ],
  };

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top' as const,
      },
      tooltip: {
        callbacks: {
          label: function(tooltipItem: any) {
            return `${tooltipItem.label}: ${tooltipItem.raw} registros`;
          }
        }
      }
    }
  };

  return <Pie data={chartData} options={options} />;
};

export default PieChartComponent;
